package pro;

public class CampingCarCompanyVO {
	private String companyID;
	private String comname;
	private String addr;
	private String tel;
	private String chargeName;
	private String chargeEMail;

	public CampingCarCompanyVO() {
	}

	public CampingCarCompanyVO(String companyID, String comname, String addr, String tel, String chargeName,
			String chargeEMail) {
		super();
		this.companyID = companyID;
		this.comname = comname;
		this.addr = addr;
		this.tel = tel;
		this.chargeName = chargeName;
		this.chargeEMail = chargeEMail;

	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getChargeName() {
		return chargeName;
	}

	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}

	public String getChargeEMail() {
		return chargeEMail;
	}

	public void setChargeEMail(String chargeEMail) {
		this.chargeEMail = chargeEMail;
	}

	public String toString() {
		return "CampingCarCompanyVO [companyID =" + companyID + ", comname =" + comname + ", addr =" + addr + ", tel ="
				+ tel + ", chargeName =" + chargeName + ", chargeEMail =" + chargeEMail + "]";
	}
}
