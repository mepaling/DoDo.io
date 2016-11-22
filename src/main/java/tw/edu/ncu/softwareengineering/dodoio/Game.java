package tw.edu.ncu.softwareengineering.dodoio;

public abstract class Game {
	public int playerID;
	public Character[] playerList;
	void start(CollideObjectManager myObjManager, String IP, String playerName);
	abstract int update();
}
