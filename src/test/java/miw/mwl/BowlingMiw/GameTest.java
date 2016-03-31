package miw.mwl.BowlingMiw;

import static org.junit.Assert.*;
import miw.mwl.BowlingMiw.Exceptions.GameFullException;
import miw.mwl.BowlingMiw.Exceptions.InvalidPlayerNumberException;
import miw.mwl.BowlingMiw.Exceptions.PlayerNameEmptyException;
import miw.mwl.BowlingMiw.Exceptions.RepeatedPlayernameException;

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

	@Test
	public void testPlayersNotEmptySuccess()
			throws InvalidPlayerNumberException, PlayerNameEmptyException,
			GameFullException, RepeatedPlayernameException {
		Game game = new Game(3);
		assertTrue(game.addPlayer("Player 1"));
	}

	@Test(expected = PlayerNameEmptyException.class)
	public void testPLayersNotEmptyError() throws InvalidPlayerNumberException,
			PlayerNameEmptyException, GameFullException,
			RepeatedPlayernameException {
		Game game = new Game(3);
		assertTrue(game.addPlayer(""));
	}

	@Test(expected = GameFullException.class)
	public void testAddPlayerToFullGame() throws InvalidPlayerNumberException,
			PlayerNameEmptyException, GameFullException,
			RepeatedPlayernameException {
		Game game = new Game(1);
		assertTrue(game.addPlayer("Player 1"));
		assertTrue(game.addPlayer("Player 2"));
	}

	@Test
	public void testUniquePlayersSuccess() throws InvalidPlayerNumberException,
			PlayerNameEmptyException, GameFullException,
			RepeatedPlayernameException {
		Game game = new Game(2);
		assertTrue(game.addPlayer("Player 1"));
		assertTrue(game.addPlayer("Player 2"));
	}

	@Test(expected = RepeatedPlayernameException.class)
	public void testUniquePlayersError() throws InvalidPlayerNumberException,
			PlayerNameEmptyException, GameFullException,
			RepeatedPlayernameException {
		Game game = new Game(2);
		assertTrue(game.addPlayer("Player 1"));
		assertTrue(game.addPlayer("Player 1"));
	}

}
