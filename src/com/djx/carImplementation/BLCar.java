package com.djx.carImplementation;

import com.djx.car.Car;

public class BLCar implements Car {
	private String MyBrand = "±öÀû";

	@Override
	public String getBrand() {
		// TODO Auto-generated method stub
		return MyBrand;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(MyBrand + " is running");
	}

}
