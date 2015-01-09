package com.maple.grade;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Printer {
	
	private ArrayList<String> resultList;
	
	Calculator calculator;
	
	public ArrayList<String> inputFromFile(){
		
		calculator = new Calculator();
		resultList = new ArrayList<String>();
		
		try{
			resultList = calculator.loadFileInfo();
		}catch (IOException e){
			e.printStackTrace();
		}
		
		return resultList;
	}
	
	public void outToFile(ArrayList<String> result){
		
		int arraySize = result.size();
		String tempResult = "";
		
		try{
			FileWriter fw = new FileWriter("GradeTable.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for(int index=0; index<arraySize; index++){
				tempResult += result.get(index);
			}
			
			bw.write(tempResult);
			bw.write("\r\n");
			bw.close();
			
		}catch(IOException e){
			
		}
	}

}
