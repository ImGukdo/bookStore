package com.work.model.service;

import java.util.ArrayList;

import com.work.model.dao.BookDao;
import com.work.model.dao.Utility;
import com.work.model.dto.Book;
import com.work.view.BookMenu;
import com.work.view.MainTest;

public class BookService {
	
	private static BookDao dao = new BookDao();
	
	public static BookDao getDao() {
		return dao;
	}
	
	public static void bookInfoMenuFunc(int input) {
		switch(input) {
		case 0 :
			System.out.println("이전으로 돌아갑니다.");
			MainTest.frontMenu();
			return;
		case 1 :
			System.out.println("\t[엔코아 서점 책리스트]");
			ArrayList<Book> list = dao.selectList();
			if(list.size() == 0) {
				System.out.println("책이 존재하지 않습니다.");
				BookMenu.bookInfoMenu();
				return;
			}
				
			else {
				for(Book b : list) {
					BookService.printBookrInfo(b);
					System.out.println();
				}
				System.out.println();
				System.out.println("====================================");
				System.out.println();
				System.out.println("### 책정보 상세보기 : 책등록번호 입력 ###");
				System.out.println("0. 이전");
				System.out.println("====================================");
				System.out.print(">> 책번호 입력: ");
				input = Utility.inputBigNumber();
				if(input == 0) {
					BookMenu.bookInfoMenu();
					return;
				}
				else {
					bookDetail(input);
					return;
				}
			}
			
		case 2 :
			System.out.println("\t[엔코아 서점 책 검색]");
			System.out.print("책 이름 : ");
			String bookName = Utility.inputString();
			list = dao.selectList(bookName);
			if(list.size() == 0) {
				System.out.println("책이 존재하지 않습니다.");
				BookMenu.bookInfoMenu();
				return;
			}
				
			else {
				for(Book b : list) {
					BookService.printBookrInfo(b);
					System.out.println();
				}
				System.out.println();
				System.out.println("====================================");
				System.out.println();
				System.out.println("### 책정보 상세보기 : 책등록번호 입력 ###");
				System.out.println("0. 이전");
				System.out.println("====================================");
				System.out.print(">> 책번호 입력: ");
				input = Utility.inputBigNumber();
				if(input == 0) {
					BookMenu.bookInfoMenu();
					return;
				}
				else {
					bookDetail(input);
					return;
				}
			}
		default :
			System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
			bookInfoMenuFunc(Utility.inputNumber());
			return;
		}
	}
	
	
	public static void bookInfoMenuAdminFunc(int input) {
		switch(input) {
		case 0 :
			System.out.println("이전으로 돌아갑니다.");
			MainTest.frontMenu();
			return;
		case 1 :
			System.out.println("\t[엔코아 서점 책리스트]");
			ArrayList<Book> list = dao.selectList();
			if(list.size() == 0) {
				System.out.println("책이 존재하지 않습니다.");
				BookMenu.bookInfoMenuAdmin();
				return;
			}
				
			else {
				for(Book b : list) {
					BookService.printBookrInfo(b);
					System.out.println();
				}
				System.out.println();
				System.out.println("====================================");
				System.out.println();
				System.out.println("### 책정보 상세보기 : 책등록번호입력 ###");
				System.out.println("0. 이전");
				System.out.println("====================================");
				System.out.print(">> 책번호 입력: ");
				input = Utility.inputBigNumber();
				if(input == 0) {
					BookMenu.bookInfoMenuAdmin();
					return;
				}
				else {
					bookDetailAdmin(input);
					return;
				}
			}
			
		case 2 :
			System.out.println("\t[엔코아 서점 책 검색]");
			System.out.print("책 이름 : ");
			String bookName = Utility.inputString();
			list = dao.selectList(bookName);
			if(list.size() == 0) {
				System.out.println("책이 존재하지 않습니다.");
				BookMenu.bookInfoMenuAdmin();
				return;
			}	
			else {
				for(Book b : list) {
					BookService.printBookrInfo(b);
					System.out.println();
				}
				System.out.println();
				System.out.println("====================================");
				System.out.println();
				System.out.println("### 책정보 상세보기 : 책등록번호입력 ###");
				System.out.println("0. 이전");
				System.out.println("====================================");
				System.out.print(">> 책번호 입력: ");
				input = Utility.inputBigNumber();
				if(input == 0) {
					BookMenu.bookInfoMenuAdmin();
					return;
				}
				else {
					bookDetailAdmin(input);
					return;
				}
			}
		case 3 :
			System.out.println("\t[책 등록]");
			
			System.out.print("1. 책 이름 : ");
			String bookName1 = Utility.inputString();
			System.out.print("2. 책 지은이 : ");
			String bookWriter1 = Utility.inputString();
			System.out.print("3. 출판사 : ");
			String bookCompany1 = Utility.inputString();
			System.out.print("4. 가격 : ");
			int bookPrice1 = Utility.inputBigNumber();
			System.out.print("5. 수량 : ");
			int bookAmount1 = Utility.inputBigNumber();
			System.out.print("6. 출판일 : ");
			String bookDate1 = Utility.inputString();
			System.out.print("7. 내용 : ");
			String bookContent1 = Utility.inputStrings();
			Book newBook = new Book(-1, bookName1, bookWriter1, bookCompany1, bookPrice1, bookAmount1,
			bookDate1, bookContent1);
			if(!BookService.bookCompare(newBook)) {
				System.out.println("이미 등록되어 있는 책입니다.");
				BookMenu.bookInfoMenuAdmin();
				return;
			}
		
			System.out.println("====================================");
			System.out.println();
			System.out.println("1. 등록하기");
			System.out.println("0. 취소");
			System.out.println("====================================");
			System.out.print(">> 메뉴입력: ");
			while(true) {
				input = Utility.inputNumber();
				if(input == 1) {
					if(dao.addBook(newBook)) {
						System.out.println("책 등록에 성공했습니다.");
						BookMenu.bookInfoMenuAdmin();
						return;
					}
					break;
				}
				else if(input == 0) {
					System.out.println("책 등록을 취소합니다.");
					BookMenu.bookInfoMenuAdmin();
					return;
				}
				else 
					System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
			}
			break;
		default :
			System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
			bookInfoMenuAdminFunc(Utility.inputNumber());
			return;
		}
	}
	
	
	public static void bookDetail(int num) {
		System.out.println("====================================");
		System.out.println("\t[엔코아 서점 책 상세 서비스]");
		System.out.println("====================================");
		Book dto = dao.selectOneNum(num);
		if(dto == null) {
			System.out.println("등록되지 않은 책번호 입니다.");
			BookMenu.bookInfoMenu();
			return; 
		}
		System.out.println(dto);
		System.out.println("====================================");
		System.out.println();
		System.out.println("1. 구매");
		System.out.println("0. 이전");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		while(true) {
			int input = Utility.inputNumber();
			if(input == 1) {
				if(BookService.buyBook(num)) {
					System.out.println("책구매에 성공했습니다.");
					BookMenu.bookInfoMenu();
					return; 
				}
				else {
					System.out.println("책 재고가 없습니다.");
					BookMenu.bookInfoMenu();
					return; 
				}
			}
			else if(input == 0) {
				System.out.println("책 구매를 취소합니다.");
				BookMenu.bookInfoMenu();
				return;
			}
			else 
				System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
		}
	}
	
	public static void bookDetailAdmin(int num) {
		System.out.println("====================================");
		System.out.println("\t[엔코아 서점 책 상세 서비스]");
		System.out.println("====================================");
		Book dto = dao.selectOneNum(num);
		if(dto == null) {
			System.out.println("등록되지 않은 책번호 입니다.");
			BookMenu.bookInfoMenuAdmin();
			return; 
		}
		System.out.println(dto);
		System.out.println("====================================");
		System.out.println();
		System.out.println("1. 변경");
		System.out.println("2. 삭제");
		System.out.println("0. 이전");
		
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		while(true) {
			int input = Utility.inputNumber();
			if(input == 1) {
				BookMenu.bookInfoUpdateMenu(num);
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
						if(dao.deleteBook(num, memberPw)) {
							System.out.println("책 삭제가 완료되었습니다.");
							BookMenu.bookInfoMenuAdmin();
							return;
						}
						else {
							System.out.println("비밀번호가 틀렸습니다.");
							BookMenu.bookInfoMenuAdmin();
							return;
						}
					}
					else if(input1 == 0) {
						System.out.println("책 삭제를 취소했습니다.");
						BookMenu.bookInfoMenuAdmin();
						return;
					}
					else {
						System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
					}		
				}
			}
			else if(input == 0) {
				System.out.println("이전으로 돌아갑니다.");
				BookMenu.bookInfoMenuAdmin();
				return;
			}
			else 
				System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
		}
	}
	
	public static void bookInfoUpdateMenuFunc(int input, int num) {
		switch(input) {
			case 0 :
				System.out.println("이전으로 돌아갑니다.");
				BookMenu.bookInfoMenuAdmin();
				return;
			case 1 :
				System.out.println("\t[가격 변경]");
				System.out.print("새 가격 : ");
				String newPrice = Utility.inputString();
				
				if(dao.updateBook("book_price", num, newPrice))
					System.out.println("책 가격이 변경되었습니다.");
				BookMenu.bookInfoMenuAdmin();
				return;
			case 2 :
				System.out.println("\t[수량 변경]");
				System.out.print("새 수량 : ");
				String newAmount = Utility.inputString();
				
				if(dao.updateBook("book_amount", num, newAmount))
					System.out.println("책 수량이 변경되었습니다.");
				BookMenu.bookInfoMenuAdmin();
				return;
			case 3 :
				System.out.println("\t[책 내용 변경]");
				System.out.print("새 내용 : ");
				String newContent = Utility.inputStrings();
				
				if(dao.updateBook("book_content", num, newContent))
					System.out.println("책 내용이 변경되었습니다.");
				BookMenu.bookInfoMenuAdmin();
				return;
			
			default :
				System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
				bookInfoUpdateMenuFunc(Utility.inputNumber(), num);
				return;
		}
	}

	
	public static boolean bookCompare(Book b) {
		ArrayList<Book> list = dao.selectList(b.getBookName());
		if(list.size() == 0)
			return true;
		for(Book b1 : list) {
			if(b1.getBookName().equals(b.getBookName()) && 
			b1.getBookWriter().equals(b.getBookWriter()) && b1.getBookCompany().equals(b.getBookCompany())) {
				return false;
			}
		}
		return true;
	}
	
	public static void printBookrInfo(Book dto) {
		System.out.print("책등록번호 : " + dto.getBookNum() + ", ");
		System.out.print("책이름 : " + dto.getBookName() + ", ");
		System.out.print("책지은이 : " + dto.getBookWriter() + ", ");
		System.out.print("출판사 : " + dto.getBookCompany() + ", ");
		System.out.print("책가격 : " + dto.getBookPrice() + ", ");
		System.out.print("수량 : " + dto.getBookAmount());
		return;
	}
	
	public static boolean buyBook(int num) {
		Book dto = dao.selectOneNum(num);
		int amount = dto.getBookAmount();
		if(amount == 0)
			return false;
		MemberService.getDao().updateMember("my_amount", MemberService.getMemberId(), null, 
				""+ (MemberService.getDao().selectOneId(MemberService.getMemberId()).getMyAmount() + 1));
		dao.updateBook("book_amount", num, "" + (amount - 1));
		
		return true;
	}
	
	
}
