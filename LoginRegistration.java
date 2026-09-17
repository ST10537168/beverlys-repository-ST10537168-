public class LoginRegistration {

    public static void main(String[] args) {

    }

    public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

}
