package pro;

public class CampingCarVO {
	private String carID;
	private String carNo;
	private String carName;
	private String passengerNo;
	private String carCost;
	private String companyID;
	private String registrationDate;
	private String cnt;
	
	public CampingCarVO(){ }
	
	public CampingCarVO(String carID, String carNo, String carName, String passengerNo, String carCost, String companyID,
			String registrationDate) {
		super();
		this.carID = carID;
		this.carNo = carNo;
		this.carName = carName;
		this.passengerNo = passengerNo;
		this.carCost = carCost;
		this.companyID = companyID;
		this.registrationDate = registrationDate;
	}
	
	public CampingCarVO(String passengerNo){
		this.passengerNo = passengerNo;
	}
	
	public CampingCarVO(String passengerNo, String cnt){
		this.passengerNo = passengerNo;
		this.cnt = cnt;
	}
	
	public String getCount(){
		return cnt;
	}

	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getPassengerNo() {
		return passengerNo;
	}

	public void setPassengerNo(String passengerNo) {
		this.passengerNo = passengerNo;
	}

	public String getCarCost() {
		return carCost;
	}

	public void setCarCost(String carCost) {
		this.carCost = carCost;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String toString() {
		return "CampingCarVO [carID =" + carID + ", carNo =" + carNo + ", carName =" + carName + ", passengerNo ="
				+ passengerNo + ", carCost =" + carCost + ", companyID =" + companyID + ", registrationDate ="
				+ registrationDate + "]";
	}
}