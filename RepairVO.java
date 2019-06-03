package pro;

public class RepairVO {
	private String repairID;
	private String carID;
	private String shopID;
	private String comID;
	private String cusLicense;
	private String repairDate;
	private String repairCost;
	private String cnt;

	public RepairVO(String shopID){
		this.shopID = shopID;
	}
	public RepairVO(String shopID, String repairCost){
		this.shopID = shopID;
		this.repairCost = repairCost;
	}
	public RepairVO(String repairID, String carID, String shopID, String comID, String cusLicense,
			String repairDate, String repairCost) {
		this.repairID = repairID;
		this.carID = carID;
		this.shopID = shopID;
		this.comID = comID;
		this.cusLicense = cusLicense;
		this.repairDate = repairDate;
		this.repairCost = repairCost;
	}

	public String getCount(){
		return cnt;
	}
	
	public String getRepairID() {
		return repairID;
	}

	public void setRepairID(String repairID) {
		this.repairID = repairID;
	}

	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public String getShopID() {
		return shopID;
	}

	public void setShopID(String shopID) {
		this.shopID = shopID;
	}

	public String getComID() {
		return comID;
	}

	public void setComID(String comID) {
		this.comID = comID;
	}

	public String getcusLicense() {
		return cusLicense;
	}

	public void setcusLicense(String cusLicense) {
		this.cusLicense = cusLicense;
	}

	public String getRepairDate() {
		return repairDate;
	}

	public void setRepairDate(String repairDate) {
		this.repairDate = repairDate;
	}

	public String getRepairCost() {
		return repairCost;
	}

	public void setRepairCost(String repairCost) {
		this.repairCost = repairCost;
	}

	public String toString() {
		return "RepairVO [repairID=" + repairID + ", carID=" + carID + ", shopID=" + shopID + ", comID=" + comID
				+ ", cusLicense=" + cusLicense + ", repairDate=" + repairDate + ", repairCosts"	+ repairCost + "]";
	}
}