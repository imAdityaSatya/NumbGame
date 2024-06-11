/**
 * NumberGame : a number guessing game made by Aditya.
 * It is a window-based application with its GUI built using the Swing framework in Java.
 */

import javax.swing.*;
import java.awt.*;

public class NumberGame2 {

    /**
     * Generates a response message based on the user's guess for the easy level.
     *
     * @param guess The user's guess.
     * @param key   The correct number.
     * @param count The number of attempts made.
     * @return The response message.
     */
    public static String guessNumEasy(int guess, int key, int count) {
        if (guess < 1 || guess > 100) {
            return "Guess-" + count + "\nPlease make a valid guess between 1 and 100.\nTry again";
        } else if (guess == key) {
            int score;
            String message = "Congrats! YOU WON!\nIt took you " + count + " guesses to win.";
            if (count <= 3) {
                score = 100;
            } else if (count <= 7) {
                score = 75;
            } else if (count <= 10) {
                score = 50;
            } else {
                score = 0;
                message = "Oh no...\nYou took " + count + " attempts to guess correctly.\nGAME OVER";
            }
            message += "\nYour Score: " + score;
            return message;
        } else if (guess > key) {
            if (guess - key <= 5) {
                return "Guess-" + count + "\nYour guess was slightly high.\nTry again";
            } else {
                return "Guess-" + count + "\nYour guess was too high.\nTry again";
            }
        } else {
            if (key - guess <= 5) {
                return "Guess-" + count + "\nYour guess was slightly low.\nTry again";
            } else {
                return "Guess-" + count + "\nYour guess was too low.\nTry again";
            }
        }
    }

    /**
     * Generates a response message based on the user's guess for the difficult
     * level.
     *
     * @param guess The user's guess.
     * @param key   The correct number.
     * @param count The number of attempts made.
     * @return The response message.
     */
    public static String guessNumDifficult(int guess, int key, int count) {
        if (guess < 1 || guess > 100) {
            return "Guess-" + count + "\nPlease make a valid guess between 1 and 100.\nTry again";
        } else if (guess == key) {
            int score;
            String message = "Congrats! YOU WON!\nIt took you " + count + " guesses to win.";
            if (count <= 3) {
                score = 100;
            } else if (count <= 7) {
                score = 75;
            } else if (count <= 10) {
                score = 50;
            } else {
                score = 0;
                message = "Oh no...\nYou took " + count + " attempts to guess correctly.\nGAME OVER";
            }
            message += "\nYour Score: " + score;
            return message;
        } else if (guess > key) {
            return "Guess-" + count + "\nYour guess was too high.\nTry again";
        } else {
            return "Guess-" + count + "\nYour guess was too low.\nTry again";
        }
    }

    /**
     * Converts the input string to an integer.
     *
     * @param s The input string.
     * @return The integer value of the input string, or -1 if the input is invalid.
     */
    public static int inputNum(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Prompts the user to select a difficulty level.
     *
     * @return The selected difficulty level.
     */
    public static int selectDifficulty() {
        Object[] options = { "Easy", "Difficult" };
        return JOptionPane.showOptionDialog(null, "Choose your difficulty level:", "NumberGame",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }

    public static void main(String[] args) {
        // Enhanced UI for the dialog boxes
        UIManager.put("OptionPane.minimumSize", new Dimension(300, 200)); // Set minimum size for dialog boxes

        // Game Introduction
        String instructions = "Welcome to the NumGame!\n\n" +
                "Rules:\n" +
                "1. The computer has chosen a number between 1 and 100.\n" +
                "2. You have to try and guess that number.\n" +
                "3. You'll be told if your guess is higher or lower than the actual number.\n" +
                "4. Let's see how many guesses you take to find the correct number!\n\n" +
                "Scoring:\n" +
                "Score will be 0: for taking more than 10 guesses\n" +
                "Score will be 50: for taking 8 to 10 guesses\n" +
                "Score will be 75: for taking 4 to 7 guesses\n" +
                "Score will be 100: for taking 1 to 3 guesses\n\n" +
                "Good luck and have fun!";
        JOptionPane.showMessageDialog(null, instructions, "NumberGame Instructions", JOptionPane.INFORMATION_MESSAGE);

        while (true) {
            int difficulty = selectDifficulty();
            if (difficulty == -1) {
                JOptionPane.showMessageDialog(null, "No difficulty selected. Exiting game.", "NumberGame",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            }

            int key = (int) (Math.random() * 100) + 1;
            int guess = 0;
            int count = 1;

            while (true) {
                String s = JOptionPane.showInputDialog(null, "Guess the number...\nChoose a number between 1 and 100",
                        "NumberGame", JOptionPane.QUESTION_MESSAGE);
                if (s == null) {
                    // User cancelled the input
                    JOptionPane.showMessageDialog(null, "Game Cancelled\nThank you for playing!", "NumberGame",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                guess = inputNum(s);
                if (guess == -1) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number between 1 and 100.",
                            "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    continue; // Skip the rest of the loop and ask for input again
                }
                String message;
                if (difficulty == 0) {      // for Easy level
                    message = guessNumEasy(guess, key, count);
                } else {        // for Difficult level
                    message = guessNumDifficult(guess, key, count);
                }
                JOptionPane.showMessageDialog(null, message, "NumberGame", JOptionPane.INFORMATION_MESSAGE);
                count++;
                if (guess == key) {
                    int playAgain = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Play Again",
                            JOptionPane.YES_NO_OPTION);
                    if (playAgain == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "Thank you for playing!\nSee ya next time arund.",
                                "End Game", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    break;
                }
            }
        }
    }
}
