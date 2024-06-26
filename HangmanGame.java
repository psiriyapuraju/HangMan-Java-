import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class HangmanGame
{
    static void Hangman(String word)
    {
        int chances = 6; // Wrong letter guesses only counts
        int trial = 0;
        List<Character> words = new ArrayList<>();
        for(char c : word.toCharArray()) // Coverting it into a character array
        {
            words.add('-');
        }
        System.out.println("The word consists of " + word.length() + " letters."); // Hint is given i.
        Scanner input = new Scanner(System.in);
        while(trial < chances)
        {
            System.out.println();
            System.out.println("This is your chance " + (trial + 1)); // Printing the chance number
            System.out.print("Enter your guess: ");  // Taking your guess
            String guess = input.nextLine();
            char guessed = guess.charAt(0);
            boolean correctGuess = false;
            List<Integer> correct = new ArrayList<>();
            for(int i = 0; i < word.length(); i++)
            {
                if(word.charAt(i) == guessed)
                {
                    words.set(i, guessed);
                    correctGuess = true;
                    correct.add(i);
                }
            }
            if(correctGuess)
            {
                System.out.println("Your guess is correct!!"); // Guessed 1 correct letter of the word.
            }
            else
            {
                trial++;
                System.out.println("Your guess is wrong! You have " + (chances - trial) + " more guesses left."); // For when the guessed letter is wrong
            }
            System.out.print("Word: "); 
            for(char c : words)
            {
                System.out.print(c + " ");
            }
            System.out.println();
            if(! words.contains('-')) // If the word doesn't contain any '-', all the letter have been guessed
            {
                System.out.println("You guessed it right! YOU WON!!");
                break;
            }
        }
        if(trial == chances)
        {
            System.out.println("You ran out of guesses. The word was " + word.toUpperCase());
        }
    }
    public static void main(String[] args)
    {
        List<String> words = new ArrayList<>(); // Pre-added a few words
        words.add("apple");
        words.add("ball");
        words.add("beautiful");
        words.add("pretty");
        words.add("happy");
        words.add("obvious");
        words.add("frivolous");
        words.add("ambiguous");
        words.add("notification");
        words.add("malicious");
        words.add("preposterous");
        Random random_word = new Random();
        String word = words.get(random_word.nextInt(words.size())); // Getting a random word out of the words list
        Hangman(word);
    }
}