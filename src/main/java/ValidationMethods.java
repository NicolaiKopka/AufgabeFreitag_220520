public class ValidationMethods {

    public static boolean[][] checkPwList(String[] pwArray) {
        boolean[][] resultArray = new boolean[pwArray.length][];
        for (int i = 0; i < pwArray.length; i++) {
            resultArray[i] = checkAllCases(pwArray[i]);
        }
        return resultArray;
    }

    public static boolean[] checkAllCases(String password) {
        boolean[] resultArray = new boolean[5];
        resultArray[0] = checkPasswordLength(password);
        resultArray[1] = checkForLowerCaseLetters(password);
        resultArray[2] = checkForUpperCaseLetters(password);
        resultArray[3] = checkForAlphaNumeric(password);
        resultArray[4] = checkForNumbers(password);
        return resultArray;
    }

    private static boolean checkForUpperCaseLetters(String password) {
        char[] charArray = password.toCharArray();
        for (char character : charArray) {
            if (Character.isUpperCase(character)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkForNumbers(String password) {
        char[] charArray = password.toCharArray();
        for (char character : charArray) {
            if (Character.isDigit(character)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkForAlphaNumeric(String password) {
        char[] charArray = password.toCharArray();
        for (char character : charArray) {
            if (!Character.isLetterOrDigit(character)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkPasswordLength(String password) {
        return password.length() >= 8;
    }

    private static boolean checkForLowerCaseLetters(String testPassword) {
        for (int i = 0; i < testPassword.length(); i++) {
            char c = testPassword.charAt(i);
            if(Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }


}
