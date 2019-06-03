package pro;

public class groupRepairVO {
	private String shopID;
	private int count;

	public groupRepairVO(String shopID, int count){
		super();
		this.shopID = shopID;
		this.count = count;
	}
		
	public String getShopID() { return shopID; }
	public void setShopID(String ID) { this.shopID = ID; }
	
	public int getCount() { return count; }
	public void setCount(int cnt) { count = cnt; }
		
	public String toString() {
		return "groupCampingCarVO [shopID = " + shopID 
						+ ", Count(*) = " + count + "]";
	}
}
