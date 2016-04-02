package miw.mwl.BowlingMiw;

import static org.junit.Assert.*;
import miw.mwl.BowlingMiw.Exceptions.AdAlreadyExistException;
import miw.mwl.BowlingMiw.Exceptions.AdvertisementNotFoundException;
import miw.mwl.BowlingMiw.Exceptions.MalformedAdvertisementException;

import org.junit.Test;

public class AdManagerTest {

	@Test
	public void testUniqueAdsSuccess() throws AdAlreadyExistException,
			MalformedAdvertisementException {
		AdManager adManager = AdManager.getInstance();
		adManager.addAd(new Advertisement("Sony", "Make belive",
				"Legal description"));
		adManager.addAd(new Advertisement("Adidas", "Impossible is nothing",
				"Legal description"));
		assertEquals(2, adManager.getAdList().size());
	}

	@Test(expected = AdAlreadyExistException.class)
	public void testUniqueAdsError() throws AdAlreadyExistException,
			MalformedAdvertisementException {
		AdManager adManager = AdManager.getInstance();
		adManager.addAd(new Advertisement("Sony", "Make belive",
				"Legal description"));
		adManager.addAd(new Advertisement("Sony", "Make belive",
				"Legal description"));
	}

	@Test(expected = MalformedAdvertisementException.class)
	public void testAdvertisementWithEmptyFields()
			throws MalformedAdvertisementException {
		new Advertisement("", "", "");
	}

	@Test
	public void testDeleteAdSuccess() throws AdAlreadyExistException,
			MalformedAdvertisementException, AdvertisementNotFoundException {
		AdManager adManager = AdManager.getInstance();
		adManager.addAd(new Advertisement("Sony", "Make belive",
				"Legal description"));
		adManager.deleteAd("Sony", "Make belive");
	}

	@Test(expected = AdvertisementNotFoundException.class)
	public void testDeleteAdError() throws AdvertisementNotFoundException,
			MalformedAdvertisementException {
		AdManager adManager = AdManager.getInstance();
		adManager.deleteAd("Sony", "Make belive");
	}

}
