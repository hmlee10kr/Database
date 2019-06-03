package pro;

public class groupCampingCarVO {
	private String passengerNo;
	private int count;
	
	public groupCampingCarVO(String passengerNo, int count){
		super();
		this.passengerNo = passengerNo;
		this.count = count;
	}
	
	public void setPassengerNo(String pNo) { passengerNo = pNo; }
	public String getPassengerNo() { return passengerNo; }
	
	public int getCount() { return count; }
	public void setCount(int cnt) { count = cnt; }

	public String toString() {
		return "groupCampingCarVO [passengerNo = " + passengerNo 
					+ ", Count(*) = " + count + "]";
	}
}
