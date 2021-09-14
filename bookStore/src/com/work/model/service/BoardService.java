package com.work.model.service;

import java.util.ArrayList;

import com.work.model.dao.BoardDao;
import com.work.model.dao.Utility;
import com.work.model.dto.Board;
import com.work.view.BoardMenu;
import com.work.view.MainTest;


public class BoardService {
	
	private static BoardDao dao = new BoardDao();
	
	public static BoardDao getDao() {
		return dao;
	}
	
	public static void boardMenuFunc(int input) {
		switch(input) {
		case 0 :
			System.out.println("이전으로 돌아갑니다.");
			MainTest.frontMenu();
			return;
		case 1 :
			System.out.println("\t[엔코아 게시글리스트]");
			ArrayList<Board> list = dao.selectList();
			if(list.size() == 0) {
				System.out.println("게시글이 존재하지 않습니다.");
				BoardMenu.boardMenu();
				return;
			}
				
			else {
				for(Board bd : list) {
					BoardService.printBoardInfo(bd);
					System.out.println();
				}
				System.out.println();
				System.out.println("====================================");
				System.out.println();
				System.out.println("### 게시글 상세보기 : 글등록번호 입력 ###");
				System.out.println("0. 이전");
				System.out.println("====================================");
				System.out.print(">> 글번호 입력: ");
				input = Utility.inputBigNumber();
				if(input == 0) {
					BoardMenu.boardMenu();
					return;
				}
				else {
					BoardMenu.boardDetail(input);
					return;
				}
			}
		case 2 :
			System.out.println("\t[글 등록]");
			
			System.out.print("1. 글 제목 : ");
			String boardTitle = Utility.inputString();
			System.out.print("2. 내용 : ");
			String boardContent = Utility.inputStrings();
			Board newBoard = new Board(-1, boardTitle, Utility.getCurrentDate(), MemberService.getMemberId(), boardContent);
		
			System.out.println("====================================");
			System.out.println();
			System.out.println("1. 등록하기");
			System.out.println("0. 취소");
			System.out.println("====================================");
			System.out.print(">> 메뉴입력: ");
			while(true) {
				input = Utility.inputNumber();
				if(input == 1) {
					if(dao.addBoard(newBoard)) {
						System.out.println("글 등록에 성공했습니다.");
						BoardMenu.boardMenu();
						return;
					}
					break;
				}
				else if(input == 0) {
					System.out.println("글 등록을 취소합니다.");
					BoardMenu.boardMenu();
					return;
				}
				else 
					System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
			}
			break;	
		case 3 :
			System.out.println("\t[엔코아 서점 게시글 검색]");
			System.out.print("글 제목 : ");
			String boardTitle1 = Utility.inputString();
			list = dao.selectList(boardTitle1);
			if(list.size() == 0) {
				System.out.println("글이 존재하지 않습니다.");
				BoardMenu.boardMenu();
				return;
			}
				
			else {
				for(Board bd : list) {
					BoardService.printBoardInfo(bd);
					System.out.println();
				}
				System.out.println();
				System.out.println("====================================");
				System.out.println();
				System.out.println("### 글 상세보기 : 글번호 입력 ###");
				System.out.println("0. 이전");
				System.out.println("====================================");
				System.out.print(">> 글번호 입력: ");
				input = Utility.inputBigNumber();
				if(input == 0) {
					BoardMenu.boardMenu();
					return;
				}
				else {
					BoardMenu.boardDetail(input);
					return;
				}
			}
		case 4 :
			System.out.println("\t[엔코아 내가 쓴 글 리스트]");
			list = dao.selectListWriter(MemberService.getMemberId());
			if(list.size() == 0) {
				System.out.println("게시글이 존재하지 않습니다.");
				BoardMenu.boardMenu();
				return;
			}
				
			else {
				for(Board bd : list) {
					BoardService.printBoardInfo(bd);
					System.out.println();
				}
				System.out.println();
				System.out.println("====================================");
				System.out.println();
				System.out.println("### 게시글 상세보기 : 글등록번호 입력 ###");
				System.out.println("0. 이전");
				System.out.println("====================================");
				System.out.print(">> 글번호 입력: ");
				input = Utility.inputBigNumber();
				if(input == 0) {
					BoardMenu.boardMenu();
					return;
				}
				else {
					BoardMenu.boardDetail(input);
					return;
				}
			}
		default :
			System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
			boardMenuFunc(Utility.inputNumber());
			return;
		}
	}
	
	public static void boardDetailAdmin(int num) {
		System.out.println("====================================");
		System.out.println();
		System.out.println("1. 수정");
		System.out.println("2. 삭제");
		System.out.println("0. 이전");
		
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		while(true) {
			int input = Utility.inputNumber();
			if(input == 1) {
				BoardMenu.boardInfoUpdateMenu(num);
			}
			else if(input == 2) {
				System.out.println("====================================");
				System.out.println();
				System.out.println("정말 삭제하시겠습니까?");
				System.out.println("1. 삭제");
				System.out.println("0. 취소");
				System.out.println("====================================");
				while(true) {	
					System.out.print(">> 메뉴입력: ");
					int input1 = Utility.inputNumber();
					if(input1 == 1) {
						System.out.print("비밀번호 : ");
						String memberPw = Utility.inputString();
						if(dao.deleteBoard(num, memberPw)) {
							System.out.println("글 삭제가 완료되었습니다.");
							BoardMenu.boardMenu();
							return;
						}
						else {
							System.out.println("비밀번호가 틀렸습니다.");
							BoardMenu.boardMenu();
							return;
						}
					}
					else if(input1 == 0) {
						System.out.println("글 삭제를 취소했습니다.");
						BoardMenu.boardMenu();
						return;
					}
					else {
						System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
					}		
				}
			}
			else if(input == 0) {
				System.out.println("이전으로 돌아갑니다.");
				BoardMenu.boardMenu();
				return;
			}
			else 
				System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
		}
	}
	
	
	public static void boardInfoUpdateMenuFunc(int input, int num) {
		switch(input) {
			case 0 :
				System.out.println("이전으로 돌아갑니다.");
				BoardMenu.boardMenu();
				return;
			case 1 :
				System.out.println("\t[제목 수정]");
				System.out.print("새 제목 : ");
				String newTitle = Utility.inputString();
				
				if(dao.updateBoard("board_title", num, newTitle))
					System.out.println("글 제목이 변경되었습니다.");
				BoardMenu.boardMenu();
				return;
			case 2 :
				System.out.println("\t[내용 변경]");
				System.out.print("새 내용 : ");
				String newContent = Utility.inputStrings();
				
				if(dao.updateBoard("board_content", num, newContent))
					System.out.println("글 내용이 변경되었습니다.");
				BoardMenu.boardMenu();
				return;
			default :
				System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
				boardInfoUpdateMenuFunc(Utility.inputNumber(), num);
				return;
		}
	}

	
	public static Board selectBoard(int num) {
		return dao.selectOneNum(num);
	}
	
	
	public static void printBoardInfo(Board dto) {
		System.out.print("게시글번호 : " + dto.getBoardNum() + ", ");
		System.out.print("글제목 : " + dto.getBoardTitle() + ", ");
		System.out.print("작성자 : " + dto.getBoardWriter() + ", ");
		System.out.print("작성일 : " + dto.getBoardDate());
		return;
	}
}
