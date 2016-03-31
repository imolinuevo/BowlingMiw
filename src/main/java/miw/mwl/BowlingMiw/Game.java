package miw.mwl.BowlingMiw;

import miw.mwl.BowlingMiw.Exceptions.InvalidPlayerNumberException;

public class Game {

	public static final int MINPLAYERNUMBER = 1;
	public static final int MAXPLAYERNUMBER = 6;

	private int playerNumber;

	public Game(int playerNumber) throws InvalidPlayerNumberException {
		if (this.isValidPlayerNumber(playerNumber)) {
			this.playerNumber = playerNumber;
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
}
