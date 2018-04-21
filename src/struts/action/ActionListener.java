package struts.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jdom.JDOMException;

import struts.core.StrutsConfig;
import struts.core.XmlBean;

public class ActionListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("信息已经注销");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext context = arg0.getServletContext();
		// TODO Auto-generated method stub
		String xmlPath = context.getInitParameter("struts-config");
		String tomcatPath = context.getRealPath("\\");
		//如果遇到包含classpath则从classes路径开始查找
		if(xmlPath.startsWith("classpath:")){
			xmlPath = xmlPath.replace("classpath:", "");
			tomcatPath = this.getClass().getResource("/").getPath();
		}
		xmlPath = tomcatPath + xmlPath;
		System.out.println("加载struts-config路径："+xmlPath);
		try {
			Map<String, XmlBean> map = StrutsConfig.add(xmlPath);
			context.setAttribute("struts", map);
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("信息：系统加载完成");
	}
	
	

}
