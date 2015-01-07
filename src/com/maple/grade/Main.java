package com.maple.grade;

import java.io.IOException;

public class Main {

	public static void main(String args[]){
		Calculator calculator = new Calculator();
		
		try{
			calculator.loadFileInfo();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
