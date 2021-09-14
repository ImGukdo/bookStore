package com.work.view;


import com.work.model.dao.Utility;
import com.work.model.dto.Board;
import com.work.model.service.BoardService;
import com.work.model.service.MemberService;

public class BoardMenu {
	
	
	public static void boardMenu() {
		System.out.println("====================================");
		System.out.println("\t[엔코아 서점 게시판]");
		System.out.println("====================================");
		System.out.println("1. 게시글리스트");
		System.out.println("2. 작성");
		System.out.println("3. 검색");
		System.out.println("4. 내가쓴글목록");
		System.out.println("0. 이전");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int input = Utility.inputNumber();
		BoardService.boardMenuFunc(input);
	}
	
	
	
	public static void boardDetail(int num) {
		System.out.println("====================================");
		System.out.println("\t[엔코아 서점 게시판 상세]");
		System.out.println("====================================");
		Board dto = BoardService.selectBoard(num);
		if(dto == null) {
			System.out.println("등록되지 않은 글번호 입니다.");
			boardMenu();
			return; 
		}
		System.out.println(dto);
		if(MemberService.getMemberId().equals("admin") || MemberService.getMemberId().equals(dto.getBoardWriter())){
			BoardService.boardDetailAdmin(num);
			return;
		}
		System.out.println("====================================");
		System.out.println();
		System.out.println("이전으로 돌아가려면 0 ~ 9 중 아무 숫자나 눌러주세요.");
		System.out.println("====================================");
		Utility.inputNumber();
		boardMenu();
		return;
	}
	
	
	public static void boardInfoUpdateMenu(int num) {
		System.out.println();
		System.out.println("====================================");
		System.out.println("\t[엔코아 서점 글 수정]");
		System.out.println("====================================");
		System.out.println("1. 제목 수정");
		System.out.println("2. 내용 수정");
		System.out.println("0. 이전");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int input = Utility.inputNumber();
		BoardService.boardInfoUpdateMenuFunc(input, num);
	}
}
