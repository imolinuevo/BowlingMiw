package miw.mwl.BowlingMiw;

import static org.junit.Assert.*;
import miw.mwl.BowlingMiw.Exceptions.InvalidPlayerNumberException;

import org.junit.Test;

public class GameTest {

	@Test
	public void testGamePlayerLimitSuccess()
			throws InvalidPlayerNumberException {
		Game game = new Game(6);
		assertEquals(6, game.getPlayerNumber());
	}

	@Test(expected = InvalidPlayerNumberException.class)
	public void testGamePlayerLimitErrorOverMinimumValue()
			throws InvalidPlayerNumberException {
		Game game = new Game(0);
		assertNull(game);
	}

	@Test(expected = InvalidPlayerNumberException.class)
	public void testGamePlayerLimitErrorOverMaximumValue()
			throws InvalidPlayerNumberException {
		Game game = new Game(7);
		assertNull(game);
	}

}
