package struts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.PanduanAction;
import service.vo.MessageVO;

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
		//String url = demo(request, name);
		String url = null;
		Action action = new PanduanAction();
		url = action.execute(request);
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

	private String demo(HttpServletRequest request, String name) {
		request.setAttribute("x", name);
		String url = null;
		MessageVO messageVO = new MessageVO();
		if(isUser(name)){
			messageVO.setName("name");
			messageVO.setMess("成功");
			messageVO.setSsss("ssss");
			messageVO.setDddd("dddd");
			url = "/view/myJsp.jsp";
		} else {
			messageVO.setName("name");
			messageVO.setMess("失败。。。。。");
			messageVO.setSsss("ssss");
			messageVO.setDddd("dddd");
			url = "/view/error.jsp";
		}
		request.setAttribute("message", messageVO);
		return url;
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
