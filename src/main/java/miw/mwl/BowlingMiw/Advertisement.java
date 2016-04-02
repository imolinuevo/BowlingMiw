package miw.mwl.BowlingMiw;

public class Advertisement {

	private String company;
	private String slogan;
	private String description;

	public Advertisement(String company, String slogan, String description) {
		this.company = company;
		this.slogan = slogan;
		this.description = description;
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
