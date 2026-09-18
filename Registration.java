package registration;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- USER REGISTRATION ---");
        
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Cell Phone Number: ");
        String cellNumber = scanner.nextLine();

        // Instantiate Login class
        Login userLogin = new Login(firstName, lastName, username, password, cellNumber);

        // Display check feedback messages individually
        if (userLogin.checkUserName(username)) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
        }

        if (userLogin.checkPasswordComplexity(password)) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }

        if (userLogin.checkCellPhoneNumber(cellNumber)) {
            System.out.println("Cell phone number successfully added.");
        } else {
            System.out.println("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.");
        }

        // Print final registration result
        String registrationMessage = userLogin.registerUser(username, password, cellNumber);
        System.out.println("\n" + registrationMessage);

        // Execute login prompt if registration succeeded
        if (registrationMessage.contains("successfully")) {
            System.out.println("\n--- USER LOGIN ---");
            
            System.out.print("Enter Username to Login: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter Password to Login: ");
            String loginPassword = scanner.nextLine();

            boolean isLoggedIn = userLogin.loginUser(loginUsername, loginPassword);
            String statusMessage = userLogin.returnLoginStatus(isLoggedIn);
            
            System.out.println("\n" + statusMessage);
        }

        scanner.close();
    }
}
