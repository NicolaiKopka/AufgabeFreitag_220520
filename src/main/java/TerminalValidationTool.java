import javax.management.remote.JMXServerErrorException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class TerminalValidationTool {
    private static final String VALIDATION_MESSAGE = "All good!";
    private static final String NO_PASSWORDS_MESSAGE = "No Passwords entered";
    private static final String FAIL_LENGTH_MESSAGE = "Password too short. min 8 characters required";
    private static final String FAIL_NUMBERS_MESSAGE = "Password does not contain numbers. At least one required";
    private static final String FAIL_UPPER_CASE_MESSAGE = "Password does not contain upper case letters. At least one required";
    private static final String FAIL_NON_ALPHA_NUMERIC_MESSAGE = "Password does not contain NonAlphaNumeric Characters. At least one required";

    public static void main(String[] args) {
        boolean running = true;
        while(running) {
            running = runProgram();
        }
    }
    private static boolean runProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Password Validation Tool");
        System.out.println("Press 1 to validate one password");
        System.out.println("Press 2 to validate multiple passwords");
        System.out.println("Press 3 to exit");
        System.out.print("Your choice: ");
        int userChoice = 0;
        try{
            userChoice = scanner.nextInt();
        } catch(InputMismatchException e) {
            System.out.println("!!!No valid input detected!!!");
            System.out.println("-----------------------");
        }

        switch (userChoice) {
            case 1:
                userChoiceOnePw();
                return true;
            case 2:
                userChoiceMultiplePws();
                return true;
            case 3:
                return false;
            default:
                return true;
        }
    }
    private static void userChoiceOnePw() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password to check");
        String password = scanner.nextLine();
        String[] messages = generateMessages(password);
        printMessages(messages);
    }

    private static void userChoiceMultiplePws() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        ArrayList<String> passwordList = new ArrayList<>();
        while(running) {
            System.out.println("Enter a password to check");
            String password = scanner.nextLine();
            if(password.length() == 0) {
                break;
            }
            passwordList.add(password);
            running = goAgainMethod();
        }
        String[] pwArray = passwordList.toArray(new String[0]);
        boolean[] resultArray = ValidationMethods.checkPwList(pwArray);
        evaluatePWResults(pwArray, resultArray);
    }
    private static boolean goAgainMethod() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while(running) {
            System.out.println("Add another password ? type <yes> or <no>");
            String userChoice = scanner.nextLine();
            if(userChoice.equals("yes")) {
                return true;
            }
            if(userChoice.equals("no")) {
                return false;
            }
        }
        return true;
    }

    private static void evaluatePWResults(String[] pwArray, boolean[] resultArray) {
        if(pwArray.length == 0) {
            System.out.println(NO_PASSWORDS_MESSAGE);
        }else {
            for (int i = 0; i < resultArray.length; i++) {
                System.out.printf("Password %d: (%s)\n", (i + 1), pwArray[i]);
                String[] messages = generateMessages(pwArray[i]);
                printMessages(messages);
                System.out.println("-----------------------");
            }
        }
    }

    private static void printMessages(String[] messageArray) {
        for (String message : messageArray) {
            System.out.println(message);
        }
    }
    public static String[] generateMessages(String password) {
        ArrayList<String> messageList = new ArrayList<>();

        if(ValidationMethods.checkAllCases(password)) {
            messageList.add(VALIDATION_MESSAGE);
        }
        if(!ValidationMethods.checkPasswordLength(password)) {
            messageList.add(FAIL_LENGTH_MESSAGE);
        }
        if(!ValidationMethods.checkForNumbers(password)) {
            messageList.add(FAIL_NUMBERS_MESSAGE);
        }
        if(!ValidationMethods.checkForUpperCaseLetters(password)) {
            messageList.add(FAIL_UPPER_CASE_MESSAGE);
        }
        if(!ValidationMethods.checkForAlphaNumeric(password)) {
            messageList.add(FAIL_NON_ALPHA_NUMERIC_MESSAGE);
        }

        return messageList.toArray(new String[0]);
    }
}
