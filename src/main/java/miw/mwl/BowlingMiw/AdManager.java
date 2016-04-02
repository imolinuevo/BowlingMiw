package miw.mwl.BowlingMiw;

import java.util.ArrayList;

import miw.mwl.BowlingMiw.Exceptions.AdAlreadyExistException;

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

	public void add(Advertisement advertisement) throws AdAlreadyExistException {
		if (isUniqueAd(advertisement)) {
			adList.add(advertisement);
		} else {
			throw new AdAlreadyExistException();
		}
	}

	private boolean isUniqueAd(Advertisement advertisement) {
		for (Advertisement ad : adList) {
			if (ad.equals(advertisement)) {
				return false;
			}
		}
		return true;
	}
}
