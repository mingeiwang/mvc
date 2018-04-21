package form.vo;

import struts.form.ActionForm;

public class PanduanForm extends ActionForm{

	private String name;
	private String password;
	private String mess;
	
	public String result;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public PanduanForm(String name, String password, String mess, String result) {
		super();
		this.name = name;
		this.password = password;
		this.mess = mess;
		this.result = result;
	}
	public PanduanForm() {
		super();
	}
	@Override
	public String toString() {
		return "PanduanForm [name=" + name + ", password=" + password + ", mess=" + mess + ", result=" + result + "]";
	}


	
	
	
}
