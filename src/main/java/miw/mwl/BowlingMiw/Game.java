package miw.mwl.BowlingMiw;

import java.util.ArrayList;
import java.util.List;

import miw.mwl.BowlingMiw.Exceptions.GameFullException;
import miw.mwl.BowlingMiw.Exceptions.InvalidPlayerNumberException;
import miw.mwl.BowlingMiw.Exceptions.PlayerNameEmptyException;
import miw.mwl.BowlingMiw.Exceptions.RepeatedPlayernameException;

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

	public boolean addPlayer(String playerName)
			throws PlayerNameEmptyException, GameFullException,
			RepeatedPlayernameException {
		if (isNotValidPlayerName(playerName)) {
			throw new PlayerNameEmptyException();
		} else if (isFullOfPlayers()) {
			throw new GameFullException();
		} else if (hasPlayerName(playerName)) {
			throw new RepeatedPlayernameException();
		} else {
			this.players.add(playerName);
			return true;
		}
	}

	private boolean isNotValidPlayerName(String playerName) {
		return playerName.trim().equals("") || playerName.equals(null);
	}

	private boolean isFullOfPlayers() {
		return this.players.size() >= this.playerNumber;
	}

	private boolean hasPlayerName(String playerName) {
		for (String player : this.players) {
			if (player.equals(playerName)) {
				return true;
			}
		}
		return false;
	}
}
