package miw.mwl.BowlingMiw;

import miw.mwl.BowlingMiw.Exceptions.MalformedAdvertisementException;

public class Advertisement {

	private String company;
	private String slogan;
	private String description;

	public Advertisement(String company, String slogan, String description)
			throws MalformedAdvertisementException {
		if (isMalformed(company, slogan, description)) {
			throw new MalformedAdvertisementException();
		} else {
			this.company = company;
			this.slogan = slogan;
			this.description = description;
		}
	}

	private boolean isMalformed(String company, String slogan,
			String description) {
		if (company.trim().equals("") || slogan.trim().equals("")
				|| description.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean equals(Advertisement advertisment) {
		if (this.company.equals(advertisment.getCompany())
				&& this.slogan.equals(advertisment.getSlogan())) {
			return true;
		} else {
			return false;
		}
	}
}
