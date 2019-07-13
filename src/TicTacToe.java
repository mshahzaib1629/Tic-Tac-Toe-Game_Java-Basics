import java.util.Scanner;

public class TicTacToe extends Game{
	
	Scanner input=new Scanner (System.in);
	
	Positions [][] array = new Positions [3][3];

	public TicTacToe(String player1, String player2) {		//Constructor
		super(player1, player2);
		for (int i=0;i<array.length;i++){
			for (int j=0;j<array[i].length;j++){
				array[i][j]=Positions.EMPTY;
			}
		}
	}
	
	public void start(){
		for (int i=1;i!=0;i++){							//Making infinite loop. Will run until any player is winner or its game draw
			
			if (checkpalyer1Winner()==true){			//At the start of loop check the status
				
				displayTable();
		
				System.out.printf("\n\n%s (palyer 1) Wins the Game ", player1);			
				break;
			}
			
			else if (checkpalyer2Winner()==true){
				
				displayTable();
		
				System.out.printf("\n\n%s (player 2) Wins the Game ", player2);								
				break;
			}
			
			else{		//If no one is winner yet
			
				
			for (int j=1; j!=0; j++){			//Making infinite loop. Will run until user enter valid data
				
					if (checkpalyer1Winner() != true && checkpalyer2Winner() != true) {

						displayTable();

						System.out.println();

						if (anyEmptyBlock() == true) {

							System.out.printf("%s (Player 1) Turn: \n", player1);
							try {
								int num1 = input.nextInt();
								int num2 = input.nextInt();

								if (array[num1][num2] == Positions.EMPTY) {
									array[num1][num2] = Positions.X;
									break;
									
								} else {
									System.out.printf("(Box is full, Choose another plz)\n");
								}
							} catch (ArrayIndexOutOfBoundsException e) {
								System.out.println("Invalid Value (Array Out Of Bound Exception) Enter Again");
							}
						}

						else {
							System.out.print("All the Blocks are Filled, Its Game Draw ");
							System.exit(0);
						}
					}
				else
					break;
			}
		
			
			for(int k=1; k!=0; k++){		//Making infinite loop. Will run until user enter valid data
				
				if (checkpalyer1Winner()!=true && checkpalyer2Winner()!=true){
			
					displayTable();
		
				System.out.println();
				
			
				
				if(anyEmptyBlock() == true){
							
				System.out.printf("%s (Player 2) Turn: \n", player2);
				try{
						int num1=input.nextInt();
						int num2=input.nextInt();
						if (array[num1][num2]==Positions.EMPTY){
							array[num1][num2]=Positions.O;
							break;
							
						}
						else{
							System.out.printf("Box is full, Choose another plz\n");
						}
				}catch(ArrayIndexOutOfBoundsException e){
					System.out.println("Invalid Value (Array Out Of Bound Exception) Enter Again");
				}
					
					} 
				else {
					System.out.print("All the Blocks are Filled, Its Game Draw ");
					System.exit(0);
					}
				}
				else
					break;
				
				}

			}

		}

	}
	
	
	public boolean checkpalyer1Winner(){
		if (array[0][0]==Positions.X && array[0][1]==Positions.X && array[0][2]==Positions.X	||							//Checking Row Wise
				array[1][0]==Positions.X && array[1][1]==Positions.X && array[1][2]==Positions.X	||
					array[2][0]==Positions.X && array[2][1]==Positions.X && array[2][2]==Positions.X	||
						array[0][0]==Positions.X && array[1][0]==Positions.X && array[2][0]==Positions.X	||				//Checking Column Wise
							array[0][1]==Positions.X && array[1][1]==Positions.X && array[2][1]==Positions.X	||
								array[0][2]==Positions.X && array[1][2]==Positions.X && array[2][2]==Positions.X	||	
									array[0][0]==Positions.X && array[1][1]==Positions.X && array[2][2]==Positions.X	||	//Checking Diagonal Wise
										array[0][2]==Positions.X && array[1][1]==Positions.X && array[2][0]==Positions.X){
			
			return true;
		}
		return false;
	}
	
	public boolean checkpalyer2Winner(){
		if (array[0][0]==Positions.O && array[0][1]==Positions.O && array[0][2]==Positions.O	||							//Checking Row Wise
				array[1][0]==Positions.O && array[1][1]==Positions.O && array[1][2]==Positions.O	||
					array[2][0]==Positions.O && array[2][1]==Positions.O && array[2][2]==Positions.O	||
						array[0][0]==Positions.O && array[1][0]==Positions.O && array[2][0]==Positions.O	||				//Checking Column Wise
							array[0][1]==Positions.O && array[1][1]==Positions.O && array[2][1]==Positions.O	||
								array[0][2]==Positions.O && array[1][2]==Positions.O && array[2][2]==Positions.O	||	
									array[0][0]==Positions.O && array[1][1]==Positions.O && array[2][2]==Positions.O	||	//Checking Diagonal Wise
										array[0][2]==Positions.O && array[1][1]==Positions.O && array[2][0]==Positions.O){
			
			return true;
		}
		return false;
	}
	
	
	public boolean anyEmptyBlock(){			//WILL RETURN TRUE IF TABLE IS NOT FULL YET
		if(array[0][0]==Positions.EMPTY || array[0][1]==Positions.EMPTY || array[0][2]==Positions.EMPTY	||							
		   array[1][0]==Positions.EMPTY || array[1][1]==Positions.EMPTY || array[1][2]==Positions.EMPTY	||
		   array[2][0]==Positions.EMPTY || array[2][1]==Positions.EMPTY || array[2][2]==Positions.EMPTY){
			return true;
		}
		return false;
	}
	
	
	public void displayTable(){
		
		System.out.println();
		for(int dp1=0; 	dp1<3;	 dp1++){
			System.out.printf("\t\t");
				for(int dp2=0; 	dp2<3;	 dp2++){

				System.out.printf("%8s%5s", array[dp1][dp2],"|");			//display Table
			}
			System.out.println();
		}
	}
	
	
	
	public void restart(){
		for (int i=0;i<array.length;i++){
			for (int j=0;j<array[i].length;j++){
				array[i][j]=Positions.EMPTY;
			}
		}
		start();
	}

	public void stop(){
		System.exit(0);
		
	}
	
}
