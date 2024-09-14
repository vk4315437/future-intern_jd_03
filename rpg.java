import java.util.Random;
import java.util.Scanner;

public class rpg {

    public static String generatePassword(int length, boolean useUpper, boolean useLower, boolean useNumbers,
            boolean useSpecial) {
        String upperLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()";

        String characterSet = "";

        if (useUpper) {
            characterSet += upperLetters;
        }
        if (useLower) {
            characterSet += lowerLetters;
        }
        if (useNumbers) {
            characterSet += numbers;
        }
        if (useSpecial) {
            characterSet += specialChars;
        }

        if (characterSet.isEmpty()) {
            return "Please choose at least one option for the password.";
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }

        return password.toString();
    }

    public static boolean yesNoToBoolean(String input) {
        return input.equalsIgnoreCase("yes");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask the user for the desired password length
        System.out.print("Enter password length: ");
        int length = sc.nextInt();
        System.out.println();

        // Ask the user for options using Yes/No
        System.out.print("Include uppercase letters? (Yes/No): ");
        boolean useUpper = yesNoToBoolean(sc.next());
        System.out.println();

        System.out.print("Include lowercase letters? (Yes/No): ");
        boolean useLower = yesNoToBoolean(sc.next());
        System.out.println();

        System.out.print("Include numbers? (Yes/No): ");
        boolean useNumbers = yesNoToBoolean(sc.next());
        System.out.println();

        System.out.print("Include special characters? (Yes/No): ");
        boolean useSpecial = yesNoToBoolean(sc.next());
        System.out.println();

        // Generate the password
        String password = generatePassword(length, useUpper, useLower, useNumbers, useSpecial);

        // Display the password
        System.out.println("Generated password: " + password);
    }
}
