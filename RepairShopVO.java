package pro;

public class RepairShopVO {
	private String shopID;
	private String shopName;
	private String shopAddr;
	private String shopTel;
	private String shopChargeName;
	private String shopChargeEmail;

	public RepairShopVO(String shopID, String shopName, String shopAddr, String shopTel, String shopChargeName,
			String shopChargeEmail) {
		this.shopID = shopID;
		this.shopName = shopName;
		this.shopAddr = shopAddr;
		this.shopTel = shopTel;
		this.shopChargeName = shopChargeName;
		this.shopChargeEmail = shopChargeEmail;
	}

	public String getShopID() {
		return shopID;
	}

	public void setShopID(String shopID) {
		this.shopID = shopID;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	public String getShopAddr() {
		return shopAddr;
	}

	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}
	
	public String getShopTel() {
		return shopTel;
	}

	public void setShopTel(String shopTel) {
		this.shopTel = shopTel;
	}

	public String getShopChargeName() {
		return shopChargeName;
	}

	public void setShopChargeName(String shopChargeName) {
		this.shopChargeName = shopChargeName;
	}

	public String getShopChargeEmail() {
		return shopChargeEmail;
	}

	public void setshopChargeEmail(String shopChargeEmail) {
		this.shopChargeEmail = shopChargeEmail;
	}

	public String toString() {
		return "RepairShopVO [shopID=" + shopID + ", shopName=" + shopName + ", shopTel=" + shopTel
				+ ", shopChargeName=" + shopChargeName + ", shopChargeEmail=" + shopChargeEmail + "]";
	}

}