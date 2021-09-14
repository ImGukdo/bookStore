package com.work.view;


import com.work.model.dao.Utility;
import com.work.model.service.MemberService;

public class MemberMenu {
	
	public static void myInfoMenu() {
		System.out.println();
		System.out.println("====================================");
		System.out.println("\t[엔코아 서점 내정보]");
		System.out.println("====================================");
		System.out.println(MemberService.selectMember(MemberService.getMemberId()));
		System.out.println("====================================");
		System.out.println();
		System.out.println("1. 변경");
		System.out.println("2. 탈퇴");
		System.out.println("0. 이전");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int input = Utility.inputNumber();
		MemberService.myInfoMenuFunc(input);
	}
	
	public static void myInfoUpdateMenu() {
		System.out.println();
		System.out.println("====================================");
		System.out.println("\t[엔코아 서점 내정보 변경]");
		System.out.println("====================================");
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 이름 변경");
		System.out.println("3. 핸드폰번호 변경");
		//System.out.println("4. 이메일 변경");
		System.out.println("0. 이전");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int input = Utility.inputNumber();
		MemberService.myInfoUpdateMenuFunc(input);
	}
	
	
	
	public static void myInfoMenuAdmin() {
		System.out.println("====================================");
		System.out.println("\t[엔코아 서점 회원정보]");
		System.out.println("====================================");
		
		System.out.println("1. 회원전체 조회");
		System.out.println("2. 회원아이디로 조회");
		System.out.println("3. 등급별회원 조회");
		System.out.println("4. 등업대상회원 조회");
		System.out.println("0. 이전");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int input = Utility.inputNumber();
		MemberService.myInfoMenuAdminFunc(input);
	}
}
