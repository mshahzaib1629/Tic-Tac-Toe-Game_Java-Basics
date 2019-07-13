import java.util.*;

public class Test{

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		
		System.out.print("Enter Player 1 Name: ");
		String p1= input.nextLine();
		
		System.out.print("Enter Player 2 Name: ");
		String p2= input.nextLine();
		
		TicTacToe play = new TicTacToe(p1, p2);

		play.start();
		System.out.printf("\nRestart the Game or Exit: (1/0): ");
		int choice = input.nextInt();
		if(choice==1){
			play.restart();
		}
		else if(choice==0){
			play.stop();
		}
		
	
	}


}