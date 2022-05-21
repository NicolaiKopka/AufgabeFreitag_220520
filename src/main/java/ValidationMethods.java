public class ValidationMethods {

    public static boolean[] checkPwList(String[] pwArray) {
        boolean[] resultArray = new boolean[pwArray.length];
        for (int i = 0; i < pwArray.length; i++) {
            resultArray[i] = checkAllCases(pwArray[i]);
        }
        return resultArray;
    }

    public static boolean checkAllCases(String password) {
        return checkPasswordLength(password) && checkForNumbers(password) && checkForUpperCaseLetters(password)
                && checkForAlphaNumeric(password);
    }

    public static boolean checkForUpperCaseLetters(String password) {
        char[] charArray = password.toCharArray();
        for (char character : charArray) {
            if (Character.isUpperCase(character)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkForNumbers(String password) {
        char[] charArray = password.toCharArray();
        for (char character : charArray) {
            if (Character.isDigit(character)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkForAlphaNumeric(String password) {
        char[] charArray = password.toCharArray();
        for (char character : charArray) {
            if (!Character.isAlphabetic(character) && !Character.isDigit(character)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkPasswordLength(String password) {
        return password.length() >= 8;
    }
}
