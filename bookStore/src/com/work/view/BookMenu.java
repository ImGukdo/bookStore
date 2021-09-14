package com.work.view;

import com.work.model.dao.Utility;
import com.work.model.service.BookService;

public class BookMenu {
	
	
	public static void bookInfoMenu() {
		System.out.println("====================================");
		System.out.println("\t[엔코아 서점 책 서비스]");
		System.out.println("====================================");
		System.out.println("1. 책 리스트");
		System.out.println("2. 책 검색");
		System.out.println("0. 이전");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int input = Utility.inputNumber();
		BookService.bookInfoMenuFunc(input);
	}
	
	
	public static void bookInfoMenuAdmin() {
		System.out.println("====================================");
		System.out.println("\t[엔코아 서점 서비스]");
		System.out.println("====================================");
		System.out.println("1. 책 리스트");
		System.out.println("2. 책 검색");
		System.out.println("3. 등록");
		System.out.println("0. 이전");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int input = Utility.inputNumber();
		BookService.bookInfoMenuAdminFunc(input);
	}
	
	
	public static void bookInfoUpdateMenu(int num) {
		System.out.println();
		System.out.println("====================================");
		System.out.println("\t[엔코아 서점 책정보 변경]");
		System.out.println("====================================");
		System.out.println("1. 가격 변경");
		System.out.println("2. 수량 변경");
		System.out.println("3. 내용 변경");
		System.out.println("0. 이전");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int input = Utility.inputNumber();
		BookService.bookInfoUpdateMenuFunc(input, num);
	}
		
}
