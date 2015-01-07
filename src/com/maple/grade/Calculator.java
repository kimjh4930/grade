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
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
	
	public String analyzeFile(String line){
		numberApiKey = "\\d{1,3}";
		
		String numberInfo = String.format(numberApiKey);
		Pattern numberPattern = Pattern.compile(numberInfo);
		Matcher numberPatternMatches = numberPattern.matcher(line);
		
		if(numberPatternMatches.find()){
			String matchResult = numberPatternMatches.group(0).trim();
			//여기에 점수 판별하는 메소드를 불러오면 될 것 같음.
		}
		
		return null;
	}

}
