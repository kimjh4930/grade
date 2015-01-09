package com.maple.grade;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {
	
	private FileInputStream fstream = null;
	private String line = null;
	private String lineResult = null;
	private String number = null;
	private String subjectName = null;
	private String numberApiKey = null;
	private String subjectNameApiKey = null;
	private double sumCredit = 0;
	private double averageCredit = 0.0;
	private int numOfSubject = 0;
	private ArrayList<String> resultList;
	
	public ArrayList<String> loadFileInfo() throws IOException {
		
		Calculator cal = new Calculator();
		resultList = new ArrayList<String>();
		
		try{
			File inFile = new File("gradeInfo.txt");
			fstream = new FileInputStream(inFile);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			//한 줄씩 불러들임
			while((line = br.readLine()) != null && line != ""){
				numOfSubject++;
				sumCredit = sumCredit + cal.analyzeFile(line).getCredit();
				resultList.add(line + " " + cal.analyzeFile(line).getGrade() + "\n");
			}
			
			averageCredit = sumCredit / numOfSubject;
			resultList.add("\n평점평균 : " + averageCredit);
			
			
		}catch(FileNotFoundException ex){
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
			
		}
		//리스트를 반환하면 좋을 것 같음.
		return resultList;
	}
	
	public GradeConvertModel analyzeFile(String line){
		String numberApiKey = "\\d{1,3}";
		int point=0;
		
		String numberInfo = String.format(numberApiKey);
		Pattern numberPattern = Pattern.compile(numberInfo);
		Matcher numberPatternMatches = numberPattern.matcher(line);
		Calculator cal = new Calculator();
		
		if(numberPatternMatches.find()){
			String matchResult = numberPatternMatches.group(0).trim();
			point = Integer.parseInt(matchResult);
			
		}
		
		return cal.convertPointToGrade(point);
	}
	
	public GradeConvertModel convertPointToGrade(int point){
		
		String grade=null;
		double credit=0;
		
		GradeConvertModel gradeConvertModel = new GradeConvertModel();
		
		switch(point/10){
		case 10 :
		case 9 : grade = "A"; 
				 credit = 4.0; break;
		case 8 : grade = "B"; 
				 credit = 3.0; break;
		case 7 : grade = "C";
		  		 credit = 2.0; break;
		case 6 : grade = "D";
				 credit = 1.0; break;
		case 5 : 
		default : grade = "F"; 
				  credit = 0.0; break;
		}
		
		gradeConvertModel.setGrade(grade);
		gradeConvertModel.setCredit(credit);
		
		return gradeConvertModel;
	}
}
