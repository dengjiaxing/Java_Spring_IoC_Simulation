package com.djx.human;

import com.djx.car.Car;

public class Human {
	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	public void myCarRun(){
		car.run();
	}
}
