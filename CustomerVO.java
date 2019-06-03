package pro;

public class CustomerVO {
	private String cusLicence;
	private String cusName;
	private String cusAddr;
	private String cusTel;
	private String cusEmail;
	private String cusPrevDate;
	private String cusPrevSort;

	public CustomerVO(String cusLicence, String cusName, String cusAddr, String cusTel, String cusEmail,
			String cusPrevDate, String cusPrevSort) {
		super();
		this.cusLicence = cusLicence;
		this.cusName = cusName;
		this.cusAddr = cusAddr;
		this.cusTel = cusTel;
		this.cusEmail = cusEmail;
		this.cusPrevDate = cusPrevDate;
		this.cusPrevSort = cusPrevSort;
	}

	public String getCusLicence() {
		return cusLicence;
	}

	public void setCusLicence(String cusLicence) {
		this.cusLicence = cusLicence;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusAddr() {
		return cusAddr;
	}

	public void setCusAddr(String cusAddr) {
		this.cusAddr = cusAddr;
	}

	public String getCusTel() {
		return cusTel;
	}

	public void setCusTel(String cusTel) {
		this.cusTel = cusTel;
	}

	public String getCusEmail() {
		return cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}

	public String getCusPrevDate() {
		return cusPrevDate;
	}

	public void setCusPrevDate(String cusPrevDate) {
		this.cusPrevDate = cusPrevDate;
	}

	public String getCusPrevSort() {
		return cusPrevSort;
	}

	public void setCusPrevSort(String cusPrevSort) {
		this.cusPrevSort = cusPrevSort;
	}

	public String toString() {
		return "CustomerrVO [cusLicence =" + cusLicence + ", cusName=" + cusName + ", cusAddr =" + cusAddr
				+ ", cusTel =" + cusTel + ", cusEmail =" + cusEmail + ", cusPrevData =" + cusPrevDate
				+ ", cusPrevSort =" + cusPrevSort + "]";
	}

}