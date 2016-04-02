package miw.mwl.BowlingMiw;

import java.util.ArrayList;

import miw.mwl.BowlingMiw.Exceptions.AdAlreadyExistException;
import miw.mwl.BowlingMiw.Exceptions.AdvertisementNotFoundException;
import miw.mwl.BowlingMiw.Exceptions.MalformedAdvertisementException;

public class AdManager {

	private static AdManager adManager = null;
	private ArrayList<Advertisement> adList;

	private AdManager() {
		this.adList = new ArrayList<Advertisement>();
	}

	public static AdManager getInstance() {
		if (adManager == null) {
			return new AdManager();
		} else {
			return adManager;
		}
	}

	public ArrayList<Advertisement> getAdList() {
		return adList;
	}

	public void addAd(Advertisement advertisement)
			throws AdAlreadyExistException {
		if (!containsAd(advertisement)) {
			adList.add(advertisement);
		} else {
			throw new AdAlreadyExistException();
		}
	}

	private boolean containsAd(Advertisement advertisement) {
		for (Advertisement ad : adList) {
			if (ad.equals(advertisement)) {
				return true;
			}
		}
		return false;
	}

	public void deleteAd(String company, String slogan)
			throws AdvertisementNotFoundException,
			MalformedAdvertisementException {
		Advertisement advertisement = findAdvertisement(company, slogan);
		adList.remove(advertisement);
	}

	private Advertisement findAdvertisement(String company, String slogan)
			throws AdvertisementNotFoundException {
		for (Advertisement advertisement : adList) {
			if (advertisement.getCompany().equals(company)
					&& advertisement.getSlogan().equals(slogan)) {
				return advertisement;
			}
		}
		throw new AdvertisementNotFoundException();
	}
}
