package struts;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import struts.action.Action;
import struts.core.XmlBean;
import struts.form.ActionForm;
import struts.form.FullBean;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//获得请求头
		String path = getPath(request.getServletPath());
		System.out.println("请求路径："+path);
		Map<String, XmlBean> map = (Map<String, XmlBean>) this.getServletContext().getAttribute("struts");
		XmlBean xmlBean = map.get(path);
		String formClass = xmlBean.getFormClass();
		//封装请求的bean
		ActionForm form = FullBean.full(formClass, request);
		String actionType = xmlBean.getActionType();
		Action action = null;
		String url = null;
		try {
			Class clazz = Class.forName(actionType);
			action = (Action) clazz.newInstance();
			url = action.execute(request,form, xmlBean.getActionForward());
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("严重：操作异常");
		}
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

	private String getPath(String servletPath){
		return servletPath.split("\\.")[0];
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private boolean isUser(String user){
		boolean b = false;
		if("xyk".equals(user)){
			b = true;
		}
		return b;
	}

}
