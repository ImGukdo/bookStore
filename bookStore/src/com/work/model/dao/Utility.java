package com.work.model.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utility {
	static private String driver = "oracle.jdbc.driver.OracleDriver";
	static private String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static private String user = "hr2";
	static private String password = "1234";
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	static void connect() {
		// 1. 드라이버 로딩 
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 2. DB 서버연결 
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3. SQL 통로개설 : 동적 SQL 수행 
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void disConnect() {
		// 6. 자원해제
		try {
			rs.close();
			stmt.close();
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static int inputNumber() {
		String inputData = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			inputData = in.readLine();
			
		} catch (IOException e) {	
			e.printStackTrace();
		}
		if(inputData.length() != 1) {
			System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
			return inputNumber();
		}
		else if(Integer.parseInt(inputData) < 0 || Integer.parseInt(inputData) > 9){
			System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
			return inputNumber();
		}
		return Integer.parseInt(inputData);
	}
	
	public static int inputBigNumber() {
		String inputData = null;
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			inputData = in.readLine();
			
		} catch (IOException e) {	
			e.printStackTrace();
		}
		for(int i = 0; i < inputData.length(); ++i) {
			if((inputData.charAt(i) < 48 || inputData.charAt(i) > 57)) {
				System.out.println("잘못입력했습니다.");
				return inputBigNumber();
			}
		}
		return Integer.parseInt(inputData);
	}
	
	
	public static String inputString() {
		String inputData = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			inputData = in.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputData;
	}
	
	public static String inputStrings() {
		String inputData = null;
		StringBuilder builder = new StringBuilder();
		while(true) {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				inputData = in.readLine();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(inputData.charAt(inputData.length() - 1) == ';') {
				builder.append(inputData);
				builder.deleteCharAt(builder.length() - 1);
				break;
			}
			builder.append(inputData);
			builder.append("\n");
		}
		return builder.toString();
	}
	
	
	public static String getCurrentDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	

	public static String getSecureCodeNumberAndString(int length) {
		StringBuilder secureCode = new StringBuilder();
		Random random = new Random((long)(System.nanoTime() * Math.random()));
		for (int index = 0; index < length; index++) {
			int temp = random.nextInt(36);
			if(temp < 10)
				secureCode.append(temp);
			else
				secureCode.append((char)(temp + 55));
		}
		return secureCode.toString();
	}
}
