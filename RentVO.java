package pro;

public class RentVO {
	private String rentID;
	private String carID;
	private String comID;
	private String cusLicence;
	private String startDate;
	private String rentPaymentDue;
	private String rentPeriod;
	private String rentCosts;

	public RentVO() {
	}

	public RentVO(String rentID, String carID, String comID, String cusLicence, String startDate, String rentPaymentDue,
			String rentPeriod, String rentCosts) {
		super();
		this.rentID = rentID;
		this.carID = carID;
		this.comID = comID;
		this.cusLicence = cusLicence;
		this.startDate = startDate;
		this.rentPaymentDue = rentPaymentDue;
		this.rentPeriod = rentPeriod;
		this.rentCosts = rentCosts;

	}

	public String getRentID() {
		return rentID;
	}

	public void setRentID(String rentID) {
		this.rentID = rentID;
	}

	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public String getComID() {
		return comID;
	}

	public void setComID(String comID) {
		this.comID = comID;
	}

	public String getCusLicence() {
		return cusLicence;
	}

	public void setCusLicence(String cusLicence) {
		this.cusLicence = cusLicence;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getRentPaymentDue() {
		return rentPaymentDue;
	}

	public void setRentPaymentDue(String rentPaymentDue) {
		this.rentPaymentDue = rentPaymentDue;
	}

	public String getRentPeriod() {
		return rentPeriod;
	}

	public void setRentPeriod(String rentPeriod) {
		this.rentPeriod = rentPeriod;
	}

	public String getRentCosts() {
		return rentCosts;
	}

	public void setRentCostd(String rentCosts) {
		this.rentCosts = rentCosts;
	}

	public String toString() {
		return "CampingCarCompanyVO [rentID =" + rentID + ", carID =" + carID + ", comID =" + comID + ", cusLicence ="
				+ cusLicence + ", startDate =" + startDate + ", rentPaymentDue =" + rentPaymentDue + ", rentPeriod ="
				+ rentPeriod + ", rentCosts =" + rentCosts + "]";
	}

}