package miw.mwl.BowlingMiw;

import java.util.ArrayList;
import java.util.List;

import miw.mwl.BowlingMiw.Exceptions.GameFullException;
import miw.mwl.BowlingMiw.Exceptions.InvalidPlayerNumberException;
import miw.mwl.BowlingMiw.Exceptions.PlayerNameEmptyException;

public class Game {

	public static final int MINPLAYERNUMBER = 1;
	public static final int MAXPLAYERNUMBER = 6;

	private int playerNumber;
	private List<String> players;

	public Game(int playerNumber) throws InvalidPlayerNumberException {
		if (this.isValidPlayerNumber(playerNumber)) {
			this.playerNumber = playerNumber;
			this.players = new ArrayList<String>();
		} else {
			throw new InvalidPlayerNumberException();
		}

	}

	private boolean isValidPlayerNumber(int playerNumber) {
		if (playerNumber > Game.MAXPLAYERNUMBER) {
			return false;
		} else if (playerNumber < Game.MINPLAYERNUMBER) {
			return false;
		} else {
			return true;
		}
	}

	public int getPlayerNumber() {
		return this.playerNumber;
	}
	
	public boolean addPlayer(String playerName) throws PlayerNameEmptyException, GameFullException {
		if(isNotValidPlayerName(playerName)) {
			throw new PlayerNameEmptyException();
		} else if(this.players.size() >= Game.MINPLAYERNUMBER) {
			throw new GameFullException();
		} else {
			this.players.add(playerName);
			return true;
		}
	}
	
	private boolean isNotValidPlayerName(String playerName) {
		return playerName.trim().equals("") || playerName.equals(null);
	}
}
