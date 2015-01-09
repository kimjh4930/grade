package com.maple.grade;

import java.util.ArrayList;

public class Main {
	
	private static ArrayList<String> result;

	public static void main(String args[]){
		
		result = new ArrayList<String>();
		Printer printer = new Printer();
		
		result = printer.inputFromFile();
		printer.outToFile(result);
	}
}
