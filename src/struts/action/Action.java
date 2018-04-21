package struts.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import struts.form.ActionForm;

public interface Action {

	String execute(HttpServletRequest request,ActionForm actionForm,Map<String, String> map);
}
