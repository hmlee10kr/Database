package pro;

public class nested2VO {
	private String repairID;
	private String companyID;
	
	
	public nested2VO(String companyId, String repairID){
		this.companyID = companyId;
		this.repairID = repairID;
	}
	
	public String getCompanyID() { return companyID; }
	public void setCompanyID(String ID) { this.companyID = ID; }
	
	public String getRepairID() { return repairID; }
	public void setRepairID(String repairID) { this.repairID = repairID; }
	
}
