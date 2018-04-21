package form.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import form.service.PanDuanService;
import form.vo.PanduanForm;
import struts.action.Action;
import struts.form.ActionForm;

public class PanduanAction implements Action {

	private PanDuanService panDuanService;
	
	
	public PanduanAction() {
		panDuanService = new PanDuanService();
	}


	@Override
	public String execute(HttpServletRequest request, ActionForm actionForm, Map<String, String> map) {
		String url = null;
		PanduanForm panduanForm = (PanduanForm) actionForm;
		if(panDuanService.deal(panduanForm)){
			panduanForm.setResult("成功");
			url = map.get("chenggong");
		} else {
			panduanForm.setResult("失败");
			url = map.get("shibai");
		}
		request.setAttribute("model", actionForm);
		return url;
	}

}
