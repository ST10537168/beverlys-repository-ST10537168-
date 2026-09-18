package registration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    
    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login("Kyl", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
    }

    @Test
    public void testCheckUserName() {
        assertTrue(login.checkUserName("kyl_1"));
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexity() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCheckCellPhoneNumber() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    @Test
    public void testRegisterUser() {
        // Success case
        assertEquals("The two above conditions have been met, and the user has been registered successfully.", 
                     login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976"));

        // Invalid Username
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", 
                     login.registerUser("kyle!!!!!!", "Ch&&sec@ke99!", "+27838968976"));

        // Invalid Password
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", 
                     login.registerUser("kyl_1", "password", "+27838968976"));

        // Invalid Cell Number
        assertEquals("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.", 
                     login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553"));
    }

    @Test
    public void testLoginUser() {
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
        assertFalse(login.loginUser("wrong_user", "WrongPass123!"));
    }

    @Test
    public void testReturnLoginStatus() {
        assertEquals("Welcome Kyl, Smith it is great to see you again.", login.returnLoginStatus(true));
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(false));
    }

    @Test
    public void testSetFirstName() {
        login.setFirstName("Jane");
        assertEquals("Welcome Jane, Smith it is great to see you again.", login.returnLoginStatus(true));
    }

    @Test
    public void testSetLastName() {
        login.setLastName("Doe");
        assertEquals("Welcome Kyl, Doe it is great to see you again.", login.returnLoginStatus(true));
    }

    @Test
    public void testGetRegisteredUsername() {
        assertEquals("kyl_1", login.getRegisteredUsername());
    }

    @Test
    public void testGetRegisteredPassword() {
        assertEquals("Ch&&sec@ke99!", login.getRegisteredPassword());
    }

    @Test
    public void testGetRegisteredCellPhoneNumber() {
        assertEquals("+27838968976", login.getRegisteredCellPhoneNumber());
    }
}
