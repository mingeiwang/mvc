package service.vo;

public class MessageVO {

	private String name;
	private String dddd;
	private String ssss;
	private String mess;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDddd() {
		return dddd;
	}
	public void setDddd(String dddd) {
		this.dddd = dddd;
	}
	public String getSsss() {
		return ssss;
	}
	public void setSsss(String ssss) {
		this.ssss = ssss;
	}
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public MessageVO(String name, String dddd, String ssss, String mess) {
		super();
		this.name = name;
		this.dddd = dddd;
		this.ssss = ssss;
		this.mess = mess;
	}
	public MessageVO() {
		super();
	}
	@Override
	public String toString() {
		return "MessageVO [name=" + name + ", dddd=" + dddd + ", ssss=" + ssss + ", mess=" + mess + "]";
	}
	
	
}
