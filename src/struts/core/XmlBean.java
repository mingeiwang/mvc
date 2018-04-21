package struts.core;

import java.util.HashMap;
import java.util.Map;

public class XmlBean {

	private String name;
	private String path;
	private String actionType;
	private String actionClass;
	private String formClass;
	private Map<String, String> actionForward = new HashMap<>();
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public String getActionClass() {
		return actionClass;
	}
	public void setActionClass(String actionClass) {
		this.actionClass = actionClass;
	}
	public String getFormClass() {
		return formClass;
	}
	public void setFormClass(String formClass) {
		this.formClass = formClass;
	}
	public Map<String, String> getActionForward() {
		return actionForward;
	}
	public void setActionForward(Map<String, String> actionForward) {
		this.actionForward = actionForward;
	}
	public XmlBean(String name, String path, String actionType, String actionClass, String formClass,
			Map<String, String> actionForward) {
		super();
		this.name = name;
		this.path = path;
		this.actionType = actionType;
		this.actionClass = actionClass;
		this.formClass = formClass;
		this.actionForward = actionForward;
	}
	public XmlBean() {
		super();
	}
	@Override
	public String toString() {
		return "XmlBean [name=" + name + ", path=" + path + ", actionType=" + actionType + ", actionClass="
				+ actionClass + ", formClass=" + formClass + ", actionForward=" + actionForward + "]";
	}
	
	
	
	
}
