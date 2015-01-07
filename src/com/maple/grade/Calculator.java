package com.maple.grade;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Calculator {
	
	private FileInputStream fstream = null;
	private String line = null;
	private String number = null;
	private String subjectName = null;
	private String numberApiKey = null;
	private String subjectNameApiKey = null;
	
	public String loadFileInfo() throws IOException {
		
		try{
			File inFile = new File("gradeInfo.txt");
			fstream = new FileInputStream(inFile);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			//한 줄씩 불러들임
			while((line = br.readLine()) != null && line != ""){
				
			}
			
			
		}catch(FileNotFoundException ex){
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
			
		}
		
		return null;
	}
	
	public String convertPointToGrade(int point){
		
		String Grade = null;
		
		switch(point/10){
		case 10 :
		case 9 : Grade = "A"; break;
		case 8 : Grade = "B"; break;
		case 7 : Grade = "C"; break;
		case 6 : Grade = "D"; break;
		case 5 : Grade = "F"; break;
		
		}
		
		return Grade;
	}

}
