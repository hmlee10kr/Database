package pro;

public class nested1VO {
	private String carID;
	private String carNo;
	
	public nested1VO(String carId, String carNo){
		this.carID = carId;
		this.carNo = carNo;
	}
	
	public String getCarID() { return carID; }
	public void setCarID(String ID) { this.carID = ID; }
	
	public String getCarNo() { return carNo; }
	public void setCarNo(String carNo) { this.carNo = carNo; }
	
}
