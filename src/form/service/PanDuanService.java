package form.service;

import form.vo.PanduanForm;
import struts.form.ActionForm;

public class PanDuanService {

	public boolean deal(PanduanForm panduanForm){
		String name = panduanForm.getName();
		String password = panduanForm.getPassword();
		String mess = panduanForm.getMess();
		System.out.println("name="+name +"|| password="+password+ "|| mess="+mess );
		if("123".equals(name) && "123".equals(password)){
			return true;
		}
		return false;
	}
}
