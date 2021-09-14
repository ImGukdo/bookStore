package com.work.view;

import com.work.model.dao.Utility;
import com.work.model.service.MemberService;

public class MainTest {

	public static void main(String[] args) {
		mainMenu();
	}
	
	public static void mainMenu() {
		System.out.println();
		System.out.println("====================================");
		System.out.println("\t[엔코아 서점]");
		System.out.println("====================================");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 아이디찾기");
		System.out.println("4. 비밀번호찾기");
		System.out.println("0. 프로그램종료");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int input = Utility.inputNumber();
		mainMenuFunc(input);
	}

	
	private static void mainMenuFunc(int input) {
		switch(input) {
			case 0 :
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			case 1 :
				MemberService.memberLonin();
				break;
			case 2 :
				MemberService.memberJoin();
				break;
			case 3 :
				MemberService.findMemberId();
				break;
			case 4 :
				MemberService.findMemberPw();
				break;
			default :
				System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
				mainMenuFunc(Utility.inputNumber());
				return;
		}
	}
	
	
	public static void frontMenu() {
		System.out.println("====================================");
		System.out.println("\t[엔코아 서점 서비스]");
		System.out.println("====================================");
		System.out.println("1. 책 리스트");
		System.out.println("2. 게시판");
		System.out.println("3. 내정보");
		System.out.println("4. 로그아웃");
		System.out.println("0. 프로그램종료");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int input = Utility.inputNumber();
		frontMenuFunc(input);
	}
	
	
	private static void frontMenuFunc(int input) {
		switch(input) {
		case 0 :
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		case 1 :
			if(MemberService.getMemberId().equals("admin")) {
				BookMenu.bookInfoMenuAdmin();
			}
			else {
				BookMenu.bookInfoMenu();
			}	
			break;
		case 2 :
			BoardMenu.boardMenu();
			break;
		case 3 :
			if(MemberService.getMemberId().equals("admin")) {
				MemberMenu.myInfoMenuAdmin();
			}
			else {
				MemberMenu.myInfoMenu();
			}	
			break;
		case 4 :
			mainMenu();
			break;
		default :
			System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
			frontMenuFunc(Utility.inputNumber());
			return;
		}
	}
}
