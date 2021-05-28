// It is a number guessing game made by Aditya
import javax.swing.*; 
public class NumberGame {

	public static String guessNum(int guess, int key, int count){
		if (guess<1 || guess>100) {
			return "Guess-"+count+"\nPlz make a valid guess..."+"\nTry again";
		}
		else if(guess==key){
			if(count<=3) {
				return  "Congrats...\nYOU  WON\nIt took you " +count+" guesses to win\nYour Score: 100";
			}
			else if(count<=7) {
				return  "Congrats...\nYOU  WON\nIt took you " +count+" guesses to win\nYour Score: 75";
			}
			else if(count<=10) {
				return  "Congrats...\nYOU  WON\nIt took you " +count+" guesses to win\nYour Score: 50";
			}
			else {
				return  "Ohh shoot...\nYou took "+count+" attempts to guess\nYour Score: 0\nGAME OVER";
			}
		}
		else if(guess>key) {
			return "Guess-"+count+"\nYour guess was a bit high"+"\nTry again";
		}
		else if(guess<key) {
			return "Guess-"+count+"\nYour guess was a bit low"+"\nTry again";
		}
		else {
			return "Guess-"+count+"\nPlz make a valid guess..."+"\nTry again";
		}
	}

	public static int inputNum(String s){
		try{
			int guess = Integer.parseInt(s);
			return guess;
		}catch(Exception e){
			return -1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int key= (int)(Math.random()*100)+1;
		int guess= 0;       
		int count= 1;
		while(guess != key) {
			String s= JOptionPane.showInputDialog(null, "Guess me if you can...\nChoose a num between 1 and 100   ", "NumberGame", JOptionPane.QUESTION_MESSAGE); 
			if(s == null){
				break;
			}
			guess = inputNum(s);
			JOptionPane.showMessageDialog(null, ""+ guessNum(guess,key,count));
			count++;
		}
	}

}
