import java.util.Scanner;
import java.util.Random;

public class Main {
    // Liste af ord til spillet
    private static final String[] WORDS = {"programmering", "java", "hangman", "udvikling", "computer", "spil", "projekt"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Vælg et tilfældigt ord fra listen
        String wordToGuess = WORDS[random.nextInt(WORDS.length)];
        char[] guessedWord = new char[wordToGuess.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        int attempts = 6;  // Antal forsøg spilleren har
        boolean wordGuessed = false;

        System.out.println("Velkommen til Hangman!");

        // Spilløb
        while (attempts > 0 && !wordGuessed) {
            System.out.println("Ordet: " + String.valueOf(guessedWord));
            System.out.println("Du har " + attempts + " forsøg tilbage.");
            System.out.print("Gæt et bogstav: ");
            char guess = scanner.nextLine().toLowerCase().charAt(0);

            boolean correctGuess = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guess && guessedWord[i] == '_') {
                    guessedWord[i] = guess;
                    correctGuess = true;
                }
            }

            if (correctGuess) {
                System.out.println("Rigtigt gæt!");
            } else {
                attempts--;
                System.out.println("Forkert gæt! Forsøg reduceret.");
            }

            // Tjek om ordet er blevet gættet
            wordGuessed = true;
            for (char c : guessedWord) {
                if (c == '_') {
                    wordGuessed = false;
                    break;
                }
            }
        }

        // Spillet er slut
        if (wordGuessed) {
            System.out.println("Tillykke! Du gættede ordet: " + wordToGuess);
        } else {
            System.out.println("Du løb tør for forsøg. Ordet var: " + wordToGuess);
        }

        scanner.close();
    }
}
