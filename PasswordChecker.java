import java.util.Scanner;

public class PasswordChecker {

    public static void main(String[] args) {

        // 1. Input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        // 2. Flags — sab false se shuru
        boolean hasUpper   = false;
        boolean hasLower   = false;
        boolean hasDigit   = false;
        boolean hasSpecial = false;

        // 3. Har character check karo
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if      (Character.isUpperCase(c)) hasUpper   = true;
            else if (Character.isLowerCase(c)) hasLower   = true;
            else if (Character.isDigit(c))     hasDigit   = true;
            else                               hasSpecial = true;
        }

        // 4. Length check
        boolean isLong = password.length() >= 8;

        // 5. Score
        int score = 0;
        if (isLong)     score++;
        if (hasUpper)   score++;
        if (hasLower)   score++;
        if (hasDigit)   score++;
        if (hasSpecial) score++;

        // 6. Strength decide karo
        String strength;
        if      (score <= 1) strength = "WEAK";
        else if (score <= 3) strength = "MEDIUM";
        else if (score == 4) strength = "STRONG";
        else               strength = "VERY STRONG";

        // 7. Output
        System.out.println("\n=== Result ===");
        System.out.println("Length okay : " + (isLong     ? "yes" : "not long enough"));
        System.out.println("Uppercase  : " + (hasUpper   ? "yes" : "no uppercase"));
        System.out.println("Lowercase  : " + (hasLower   ? "yes" : "no lowercase"));
        System.out.println("Digit      : " + (hasDigit   ? "yes" : "no digit"));
        System.out.println("Special character   : " + (hasSpecial ? "yes" : "no special character"));
        System.out.println("Score      : " + score + "/5");
        System.out.println("Strength   : " + strength);

        // 8. Suggestions
        System.out.println("\n--- Suggestions ---");
        if (!isLong)     System.out.println("- give atleast 8 characters");
        if (!hasUpper)   System.out.println("- add UPPERCASE letter");
        if (!hasLower)   System.out.println("- add lowercase letter");
        if (!hasDigit)   System.out.println("- add Number from (0-9)");
        if (!hasSpecial) System.out.println("- add Special char (!@#$%)");
        if (score == 5) System.out.println("yes Perfect password!");

        sc.close();
    }
}