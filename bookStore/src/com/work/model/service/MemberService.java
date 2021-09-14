package com.work.model.service;

import com.work.model.dao.Utility;
import com.work.model.dto.Member;
import com.work.view.MainTest;

import java.util.ArrayList;

import com.work.model.dao.MemberDao;
import com.work.view.MemberMenu;

public class MemberService {

	private static String memberId;
	private static String memberPw;
	private static String name;
	private static String mobile;
	private static String email;
	private static MemberDao dao = new MemberDao();
	
	
	/**
	 * @return the memberId
	 */
	public static String getMemberId() {
		return memberId;
	}
	
	public static MemberDao getDao() {
		return dao;
	}

	public static void memberJoin() {
		System.out.println();
		System.out.println("====================================");
		System.out.println("\t[엔코아 서점 회원가입]");
		System.out.println("====================================");
		
		while(true) {
			System.out.print("1. 아이디 : ");
			memberId = Utility.inputString();
			if(dao.selectOneId(memberId) == null) {
				break;
			}
			System.out.println("이미 존재하는 아이디입니다.");
		}
		
		System.out.print("2. 비밀번호 : ");
		memberPw = Utility.inputString();
		
		System.out.print("3. 이름 : ");
		name = Utility.inputString();
		
		System.out.print("4. 핸드폰번호 : ");
		mobile = Utility.inputString();
		
		while(true) {
			System.out.print("5. 이메일 : ");
			email = Utility.inputString();
			if(dao.selectOneEmail(email) == null) {
				break;
			}
			System.out.println("이미 가입한 이메일입니다.");
		}
		
		System.out.println("====================================");
		
		System.out.println();
		System.out.println("1. 가입완료");
		System.out.println("0. 취소");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int input = Utility.inputNumber();
		memberJoinFunc(input);
		}
		
		private static void memberJoinFunc(int input) {
			switch(input) {
			case 1 :
				Member dto = new Member(memberId, memberPw, name, mobile, email);
				if(dao.addMember(dto)) {
					System.out.println("회원가입에 성공했습니다.");
					MainTest.mainMenu();
					return;
				}
				break;
			case 0 :
				System.out.println("회원가입을 취소합니다.");
				MainTest.mainMenu();
				return;
			default :
				System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
				memberJoinFunc(Utility.inputNumber());
				return;
			}
		}
		
		
		public static void memberLonin() {
			System.out.println();
			System.out.println("====================================");
			System.out.println("\t[엔코아 서점 로그인]");
			System.out.println("====================================");
			
			System.out.print("1. 아이디 : ");
			memberId = Utility.inputString();
			
			System.out.print("2. 비밀번호 : ");
			memberPw = Utility.inputString();
			
			System.out.println("====================================");
			
			System.out.println();
			System.out.println("1. 로그인");
			System.out.println("0. 취소");
			System.out.println("====================================");
			System.out.print(">> 메뉴입력: ");
			int input = Utility.inputNumber();
			memberLoginFunc(input);
		}
		
		private static void memberLoginFunc(int input) {
			switch(input) {
			case 1 :
				Member dto = dao.selectOneId(memberId);
				if(dto != null) {
					if(dto.getMemberPw().equals(memberPw)) {
						System.out.println("로그인에 성공했습니다.");
						
						MainTest.frontMenu();
						return;
					}
					System.out.println("로그인에 실패했습니다. 아이디와 비밀번호를 다시 확인하세요.");
					memberLonin();
					return;
				}
				System.out.println("로그인에 실패했습니다. 아이디와 비밀번호를 다시 확인하세요.");
				memberLonin();
				return;
			case 0 :
				System.out.println("로그인을 취소합니다.");
				MainTest.mainMenu();
				return;
			default :
				System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
				memberLoginFunc(Utility.inputNumber());
				return;
			}
		}
		
	public static void findMemberId() {
		System.out.println();
		System.out.println("====================================");
		System.out.println("\t[엔코아 서점 아이디찾기]");
		System.out.println("====================================");
		
		System.out.print("1. 이메일 : ");
		email = Utility.inputString();
		
		System.out.print("2. 이름 : ");
		name = Utility.inputString();
		
		System.out.println("====================================");
		
		System.out.println();
		System.out.println("1. 아이디찾기");
		System.out.println("0. 취소");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int input = Utility.inputNumber();
		findMemberIdFunc(input);
	}
	
	private static void findMemberIdFunc(int input) {
		switch(input) {
		case 1 :
			Member dto = dao.selectOneEmail(email);
			if(dto != null) {
				if(dto.getName().equals(name)) {
					System.out.println("회원님의 아이디는 '" + dto.getMemberId() + "' 입니다.");
					MainTest.mainMenu();
					return;
				}
				System.out.println("아이디찾기에 실패했습니다. 회원정보를 다시 확인하세요.");
				findMemberId();
				return;
			}
			System.out.println("등록되지 않은 회원정보입니다. 회원정보를 다시 확인하세요.");
			findMemberId();
			return;
		case 0 :
			System.out.println("아이디찾기를 취소합니다.");
			MainTest.mainMenu();
			return;
		default :
			System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
			findMemberIdFunc(Utility.inputNumber());
			return;
		}
	}
	
	public static void findMemberPw() {
		System.out.println();
		System.out.println("====================================");
		System.out.println("\t[엔코아 서점 비밀번호찾기]");
		System.out.println("====================================");
		
		System.out.print("1. 아이디 : ");
		memberId = Utility.inputString();
		
		System.out.print("2. 이름 : ");
		name = Utility.inputString();
		
		System.out.println("====================================");
		
		System.out.println();
		System.out.println("1. 비밀번호찾기");
		System.out.println("0. 취소");
		System.out.println("====================================");
		System.out.print(">> 메뉴입력: ");
		int input = Utility.inputNumber();
		findMemberPwFunc(input);
	}
	
	private static void findMemberPwFunc(int input) {
		switch(input) {
		case 1 :
			Member dto = dao.selectOneId(memberId);
			if(dto != null) {
				if(dto.getName().equals(name)) {
					String tempPw = dao.updateMember(memberId);
					System.out.println("회원님의 임시 비밀번호는 '" + tempPw + "' 입니다.");
					MainTest.mainMenu();
					return;
				}
				System.out.println("비밀번호찾기에 실패했습니다. 회원정보를 다시 확인하세요.");
				findMemberPw();
				return;
			}
			System.out.println("등록되지 않은 회원정보입니다. 회원정보를 다시 확인하세요.");
			findMemberPw();
			return;
		case 0 :
			System.out.println("비밀번호찾기를 취소합니다.");
			MainTest.mainMenu();
			return;
		default :
			System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
			findMemberIdFunc(Utility.inputNumber());
			return;
		}
	}
	
	public static void myInfoMenuFunc(int input) {
		switch(input) {
			case 0 :
				System.out.println("이전으로 돌아갑니다.");
				MainTest.frontMenu();
				return;
			case 1 :
				MemberMenu.myInfoUpdateMenu();
				break;
			case 2 :
				System.out.println("====================================");
				System.out.println();
				System.out.println("정말 탈퇴하시겠습니까?");
				System.out.println("1. 탈퇴");
				System.out.println("0. 취소");
				System.out.println("====================================");
				while(true) {	
					System.out.print(">> 메뉴입력: ");
					int input1 = Utility.inputNumber();
					if(input1 == 1) {
						System.out.print("비밀번호 : ");
						String memberPw = Utility.inputString();
						if(dao.deleteMember(memberId, memberPw)) {
							System.out.println("회원탈퇴가 완료되었습니다.");
							MainTest.mainMenu();
							return;
						}
						else {
							System.out.println("비밀번호가 틀렸습니다.");
							MemberMenu.myInfoMenu();
							return;
						}
					}
					else if(input1 == 0) {
						System.out.println("회원탈퇴를 취소했습니다.");
						MemberMenu.myInfoMenu();
						return;
					}
					else {
						System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
					}		
				}
			
			default :
				System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
				myInfoMenuFunc(Utility.inputNumber());
				return;
		}
	}
	
	public static void myInfoUpdateMenuFunc(int input) {
		switch(input) {
			case 0 :
				System.out.println("이전으로 돌아갑니다.");
				MemberMenu.myInfoMenu();
				return;
			case 1 :
				System.out.println("\t[비밀번호 변경]");
				System.out.print("기존 비밀번호 : ");
				String memberPw1 = Utility.inputString();
				System.out.print("새 비밀번호 : ");
				String memberNewPw = Utility.inputString();
				if(dao.updateMember("member_pw", memberId, memberPw1, memberNewPw))
					System.out.println("비밀번호가 변경되었습니다.");
				else 
					System.out.println("기존 비밀번호가 틀렸습니다.");
				MemberMenu.myInfoMenu();
				return;
			case 2 :
				System.out.println("\t[이름 변경]");
				System.out.print("새 이름 : ");
				String newName = Utility.inputString();
				if(dao.updateMember("name", memberId, null, newName)) {
					System.out.println("이름이 변경되었습니다.");
				}
				MemberMenu.myInfoMenu();
				return;
			case 3 :
				System.out.println("\t[핸드폰번호 변경]");
				System.out.print("새 핸드폰번호 : ");
				String newMobile = Utility.inputString();
				if(dao.updateMember("mobile", memberId, null, newMobile)) {
					System.out.println("핸드폰번호가 변경되었습니다.");
				}	
				MemberMenu.myInfoMenu();
				return;
//			case 4 :
//				System.out.println("\t[이메일 변경]");
//				System.out.print("새 이메일 : ");
//				String newEmail = Utility.inputString();
//				if(dao.updateMember("email", dto.getMemberId(), null, newEmail)) {
//					System.out.println("이메일이 변경되었습니다.");
//					dto = dao.selectOneId(MemberService.getMemberId());
//				}	
//				myInfoMenu();
//				return;
			default :
				System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
				myInfoUpdateMenuFunc(Utility.inputNumber());
				return;
		}
	}
	
	public static void myInfoMenuAdminFunc(int input) {
		switch(input) {
		case 0 :
			System.out.println("이전으로 돌아갑니다.");
			MainTest.frontMenu();
			return;
		case 1 :
			System.out.println("\t[엔코아 서점 회원리스트]");
			ArrayList<Member> list = dao.selectList();
			if(list.size() == 0)
				System.out.println("회원이 존재하지 않습니다.");
			else {
				for(Member mem : list) {
					if(mem.getMemberId().equals("admin"))
						continue;
					MemberService.printMemberInfo(mem);
					System.out.println();
				}
			}
			
			System.out.println("====================================");
			System.out.println();
			System.out.println("이전으로 돌아가려면 0 ~ 9 중 아무 숫자나 눌러주세요.");
			System.out.println("====================================");
			Utility.inputNumber();
			MemberMenu.myInfoMenuAdmin();
			return;
		case 2 :
			System.out.println("\t[회원아이디로 조회]");
			System.out.print("아이디 : ");
			String memberId = Utility.inputString();
			Member mem = dao.selectOneId(memberId);
			if(mem != null)
				MemberService.printMemberInfo(mem);
			else
				System.out.println("해당 아이디의 회원이 존재하지 않습니다.");
			System.out.println();
			System.out.println("====================================");
			System.out.println();
			System.out.println("이전으로 돌아가려면 0 ~ 9 중 아무 숫자나 눌러주세요.");
			System.out.println("====================================");
			Utility.inputNumber();
			MemberMenu.myInfoMenuAdmin();
			return;
		case 3 :
			System.out.println("\t[등급별회원 조회]");
			System.out.print("등급 : ");
			String grade = Utility.inputString();
			list = dao.selectList(grade, 0);
			if(list.size() == 0)
				System.out.println("회원이 존재하지 않습니다.");
			else {
				for(Member mem1 : list) {
					if(mem1.getMemberId().equals("admin"))
						continue;
					MemberService.printMemberInfo(mem1);
					System.out.println();
				}
			}
			
			System.out.println("====================================");
			System.out.println();
			System.out.println("이전으로 돌아가려면 0 ~ 9 중 아무 숫자나 눌러주세요.");
			System.out.println("====================================");
			Utility.inputNumber();
			MemberMenu.myInfoMenuAdmin();
			return;
		case 4 :
			System.out.println("\t[등업대상회원 조회]");
			list = dao.selectList("일반", 5);
			if(list.size() == 0)
				System.out.println("회원이 존재하지 않습니다.");
			else {
				for(Member mem1 : list) {
					if(mem1.getMemberId().equals("admin"))
						continue;
					MemberService.printMemberInfo(mem1);
					System.out.println();
				}
			}
			
			System.out.println("====================================");
			System.out.println();
			System.out.println("1. 등업시키기");
			System.out.println("0. 이전");
			System.out.println("====================================");
			
			while(true) {
				int input1 = Utility.inputNumber();
				if(input1 == 1) {
					if(list.size() != 0 && dao.updateMember()) {
						System.out.println("등업이 완료되었습니다.");
					}
					else if(list.size() == 0) {
						System.out.println("등업 대상이 없습니다.");
					}	
					break;
				}
				else if(input1 == 0)
					break;
				else 
					System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
			}
			MemberMenu.myInfoMenuAdmin();
			return;
		default :
			System.out.print("잘못입력했습니다. 메뉴의 번호중 선택해주세요. : ");
			myInfoMenuAdminFunc(Utility.inputNumber());
			return;
		}
	}
	
	
	public static Member selectMember(String memberId) {
		return dao.selectOneId(memberId);
	}
	
	
	public static void printMemberInfo(Member dto) {
		System.out.print("아이디 : " + dto.getMemberId() + ", ");
		System.out.print("이름 : " + dto.getName() + ", ");
		System.out.print("핸드폰번호 : " + dto.getMobile() + ", ");
		System.out.print("이메일 : " + dto.getEmail() + ", ");
		System.out.print("가입일 : " + dto.getEntryDate() + ", ");
		System.out.print("등급 : " + dto.getGrade() + ", ");
		System.out.print("누적구매수 : " + dto.getMyAmount());
		return;
	}
}
