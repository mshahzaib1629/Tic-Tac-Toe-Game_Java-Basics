
public abstract class Game {
	
	protected String player1;
	protected String player2;
	
	
	abstract void start();
	
	abstract void stop();
	abstract void restart();

	public Game(String player1, String player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
}
