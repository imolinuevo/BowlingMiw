package miw.mwl.BowlingMiw;

import static org.junit.Assert.*;
import miw.mwl.BowlingMiw.Exceptions.AdAlreadyExistException;
import miw.mwl.BowlingMiw.Exceptions.MalformedAdvertisementException;

import org.junit.Test;

public class AdManagerTest {

	@Test
	public void testUniqueAdsSuccess() throws AdAlreadyExistException,
			MalformedAdvertisementException {
		AdManager adManager = AdManager.getInstance();
		adManager.add(new Advertisement("Sony", "Make belive",
				"Legal description"));
		adManager.add(new Advertisement("Adidas", "Impossible is nothing",
				"Legal description"));
		assertEquals(2, adManager.getAdList().size());
	}

	@Test(expected = AdAlreadyExistException.class)
	public void testUniqueAdsError() throws AdAlreadyExistException,
			MalformedAdvertisementException {
		AdManager adManager = AdManager.getInstance();
		adManager.add(new Advertisement("Sony", "Make belive",
				"Legal description"));
		adManager.add(new Advertisement("Sony", "Make belive",
				"Legal description"));
	}

	@Test(expected = MalformedAdvertisementException.class)
	public void testAdvertisementWithEmptyFields()
			throws MalformedAdvertisementException {
		new Advertisement("", "", "");
	}

}
