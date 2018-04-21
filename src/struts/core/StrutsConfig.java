package struts.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.sun.org.apache.xml.internal.serializer.ElemDesc;

public class StrutsConfig {

	
	public StrutsConfig() {
		// TODO Auto-generated constructor stub
	}
	
	public static Map<String, XmlBean> add(String xmlPath) throws JDOMException, IOException{
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(new File(xmlPath));
		Element root = doc.getRootElement();
		Map<String, XmlBean> xml = new HashMap<>();
		/*Element actionForm = root.getChild("formbeans");
		List<Element> forms = actionForm.getChildren();
		for (Element element : forms) {
			String name = element.getAttributeValue("name");
			String clas = element.getAttributeValue("class");
			System.out.println("formbenas:name="+name+"||class="+clas);
		}*/
		Element actionRoot = root.getChild("action-mapping");
		List<Element> actions = actionRoot.getChildren();
		for (Element element : actions) {
			XmlBean xmlBean = new XmlBean();
			String name = element.getAttributeValue("name");
			String type = element.getAttributeValue("type");
			String path = element.getAttributeValue("path");
			String classPath = null;
			Element actionForm = root.getChild("formbeans");
			List<Element> form = actionForm.getChildren();
			for (Element element2 : form) {
				if(name.equals(element2.getAttributeValue("name"))){
					classPath = element2.getAttributeValue("class");
					break;
				}
				
			}
			xmlBean.setName(name);
			xmlBean.setPath(path);
			xmlBean.setActionClass(classPath);
			xmlBean.setActionType(type);
			List<Element> forwards = element.getChildren();
			System.out.println("actionRoot:name="+name+"||type="+type+"||path="+path);;
			Map<String, String> map = xmlBean.getActionForward();
			for (Element element2 : forwards) {
				String name1 = element2.getAttributeValue("name");
				String value = element2.getAttributeValue("value");
				map.put(name1, value);
			}
			xmlBean.setActionForward(map);
			xml.put(path, xmlBean);
		}
		return xml;
	}
	
	public static void main(String[] args) {
		StrutsConfig config = new StrutsConfig();
		String path = config.getClass().getResource("/").getPath();
		System.out.println("路径："+path);
		try {
			Map<String, XmlBean> map = config.add(path+"struts/core/struts-config.xml");
			System.out.println(map);
			Set<String> set = map.keySet();
			for (String string : set) {
				System.out.println("----------------------------------");
				System.out.println(string);
				System.out.println(map.get(string));
			}
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
