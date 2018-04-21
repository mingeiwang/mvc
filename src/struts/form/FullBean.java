package struts.form;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

public class FullBean {

	public FullBean() {
		// TODO Auto-generated constructor stub
	}
	
	public static ActionForm full(String className,HttpServletRequest request){
		ActionForm form = null;
		try {
			Class clazz = Class.forName(className);
			form = (ActionForm) clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				field.set(form, request.getParameter(field.getName()));
				field.setAccessible(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("严重：form装载失败");
			e.printStackTrace();
			
		}
		return form;
	}
}
