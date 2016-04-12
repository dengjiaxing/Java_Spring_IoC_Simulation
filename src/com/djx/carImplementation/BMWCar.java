package com.djx.carImplementation;

import java.util.jar.Attributes.Name;

import com.djx.car.Car;

public class BMWCar implements Car {

	private String MyBrand="±¦Âí";
	@Override
	public String getBrand() {
		// TODO Auto-generated method stub
		return MyBrand;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(MyBrand+"is running");
	}

}
