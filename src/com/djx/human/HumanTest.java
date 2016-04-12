package com.djx.human;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.jdom.JDOMException;
import org.junit.Before;
import org.junit.Test;

import com.djx.Spring.ClassPathXmlApplicationContext;
import com.djx.car.Car;

public class HumanTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws InstantiationException, IllegalAccessException, ClassNotFoundException, JDOMException, IOException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		/*Human human=new Human();
		Car car=new BMWCar();
		human.setCar(car);
		human.myCarRun();*/
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext();
		Human huamn=(Human) ctx.getBean("human");
		/*Car car=(Car) ctx.getBean("car");
		huamn.setCar(car);*/
		huamn.myCarRun();
	}

}
