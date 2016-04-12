package com.djx.Spring;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Element;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ClassPathXmlApplicationContext implements BeanFactory {

	private Map<String, Object>beans=new HashMap<>();
	public ClassPathXmlApplicationContext() throws JDOMException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated constructor stub
		SAXBuilder sb=new SAXBuilder();
		Document doc=sb.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
		org.jdom.Element root=doc.getRootElement();
		List list=root.getChildren("bean");
		for (int i = 0; i < list.size(); i++) {
			org.jdom.Element element=(org.jdom.Element) list.get(i);
			String id=element.getAttributeValue("id");
			String clazz=element.getAttributeValue("class");
			Object o=Class.forName(clazz).newInstance();//ʹ�÷���������Ķ���
			System.out.println(id);
			System.out.println(clazz);
			beans.put(id, o);
			List<org.jdom.Element> children=element.getChildren("property");
			for(org.jdom.Element propertyElement:children){
				String name=propertyElement.getAttributeValue("name");
				String beanInstance=propertyElement.getAttributeValue("bean");
				Object beanObject=beans.get(beanInstance);//��ñ�ע���ʵ��
				String methodName="set"+name.substring(0, 1).toUpperCase()+name.substring(1);
				System.out.println("method name="+methodName);
				Method m=o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);
				m.invoke(o, beanObject);//���ö���o��set����
			}
		}
	}
	@Override
	public Object getBean(String id) {
		// TODO Auto-generated method stub
		return beans.get(id);
	}

}
