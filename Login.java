package registration;

public class Login {
    // Instance variables
    private String firstName;
    private String lastName;
    private String registeredUsername;
    private String registeredPassword;
    private String registeredCellPhoneNumber;

    // Constructor
    public Login(String firstName, String lastName, String username, String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registeredUsername = username;
        this.registeredPassword = password;
        this.registeredCellPhoneNumber = cellPhoneNumber;
    }

    // Check username rules (contains '_' and <= 5 characters)
    public boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    // Check password complexity rules
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasCapital = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(ch)) {
                hasSpecial = true;
            }
        }

        return hasCapital && hasDigit && hasSpecial;
    }

    // Check international cell phone format (+ followed by 10 to 12 digits)
    public boolean checkCellPhoneNumber(String cellNumber) {
        return cellNumber != null && cellNumber.matches("^\\+\\d{10,12}$");
    }

    // Register user and return registration status string
    public String registerUser(String username, String password, String cellNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        this.registeredUsername = username;
        this.registeredPassword = password;
        this.registeredCellPhoneNumber = cellNumber;
        return "The two above conditions have been met, and the user has been registered successfully.";
    }

    // Verify login credentials
    public boolean loginUser(String username, String password) {
        return this.registeredUsername != null && 
               this.registeredUsername.equals(username) && 
               this.registeredPassword != null && 
               this.registeredPassword.equals(password);
    }

    // Return login status string
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }

    // Setters and Getters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRegisteredUsername() {
        return registeredUsername;
    }

    public String getRegisteredPassword() {
        return registeredPassword;
    }

    public String getRegisteredCellPhoneNumber() {
        return registeredCellPhoneNumber;
    }
}
