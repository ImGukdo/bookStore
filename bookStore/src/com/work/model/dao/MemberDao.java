package com.work.model.dao;


import java.sql.SQLException;
import java.util.ArrayList;

import com.work.model.dto.Member;

public class MemberDao {

	public boolean addMember(Member dto) {
		Utility.connect();
		String sql = "insert into member values('" + dto.getMemberId() + "', '" + dto.getMemberPw() + "', '" +
		dto.getName() + "', '" + dto.getMobile() + "', '" + dto.getEmail() + "', '" +
				Utility.getCurrentDate() + "', '" + dto.getGrade() + "', '" + dto.getMyAmount() + "')";
		try {
			Utility.rs = Utility.stmt.executeQuery(sql);
			Utility.stmt.executeQuery("commit");
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
			return false;
		}
		Utility.disConnect();
		return true;
	}
	
	public ArrayList<Member> selectList(){
		ArrayList<Member> list = new ArrayList<Member>();
		Utility.connect();
		
		// 4. SQL수행요청
		try {
			Utility.rs = Utility.stmt.executeQuery("select * from member");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 5. 결과처리
		try {
			while(Utility.rs.next()) {
				Member dto = new Member();
				dto.setMemberId(Utility.rs.getString("member_id"));
				dto.setMemberPw(Utility.rs.getString("member_pw"));
				dto.setName(Utility.rs.getString("name"));
				dto.setMobile(Utility.rs.getString("mobile"));
				dto.setEmail(Utility.rs.getString("email"));
				dto.setEntryDate(Utility.rs.getString("entrydate"));
				dto.setGrade(Utility.rs.getString("grade"));
				dto.setMyAmount(Utility.rs.getInt("my_amount"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Utility.disConnect();
	
		return list;
	}
	
	public ArrayList<Member> selectList(String grade, int num){
		ArrayList<Member> list = new ArrayList<Member>();
		Utility.connect();
		String sql = null;
		if(num == 0)
			sql = "select * from member where grade = '" + grade + "'";
		else if(num == 5)
			sql = "select * from member where grade = '일반' and my_amount >= 5";
		
		// 4. SQL수행요청
		try {
			Utility.rs = Utility.stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 5. 결과처리
		try {
			while(Utility.rs.next()) {
				Member dto = new Member();
				dto.setMemberId(Utility.rs.getString("member_id"));
				dto.setMemberPw(Utility.rs.getString("member_pw"));
				dto.setName(Utility.rs.getString("name"));
				dto.setMobile(Utility.rs.getString("mobile"));
				dto.setEmail(Utility.rs.getString("email"));
				dto.setEntryDate(Utility.rs.getString("entrydate"));
				dto.setGrade(Utility.rs.getString("grade"));
				dto.setMyAmount(Utility.rs.getInt("my_amount"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Utility.disConnect();
	
		return list;
	}

	
	public Member selectOneId(String memberId) {
		String sql = "select * from member where member_id = '" + memberId + "'";
		Utility.connect();
		try {
			Utility.rs = Utility.stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Member dto = null;
		try {
			if(Utility.rs.next()) {
				dto = new Member();
				dto.setMemberId(Utility.rs.getString("member_id"));
				dto.setMemberPw(Utility.rs.getString("member_pw"));
				dto.setName(Utility.rs.getString("name"));
				dto.setMobile(Utility.rs.getString("mobile"));
				dto.setEmail(Utility.rs.getString("email"));
				dto.setEntryDate(Utility.rs.getString("entrydate"));
				dto.setGrade(Utility.rs.getString("grade"));
				dto.setMyAmount(Utility.rs.getInt("my_amount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Utility.disConnect();
		return dto;
	}
	
	public Member selectOneEmail(String email) {
		String sql = "select * from member where email = '" + email + "'";
		Utility.connect();
		try {
			Utility.rs = Utility.stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Member dto = null;
		try {
			if(Utility.rs.next()) {
				dto = new Member();
				dto.setMemberId(Utility.rs.getString("member_id"));
				dto.setMemberPw(Utility.rs.getString("member_pw"));
				dto.setName(Utility.rs.getString("name"));
				dto.setMobile(Utility.rs.getString("mobile"));
				dto.setEmail(Utility.rs.getString("email"));
				dto.setEntryDate(Utility.rs.getString("entrydate"));
				dto.setGrade(Utility.rs.getString("grade"));
				dto.setMyAmount(Utility.rs.getInt("my_amount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Utility.disConnect();
		return dto;
	}

	public String updateMember(String memberId) {
		String tempPw = Utility.getSecureCodeNumberAndString(6);
		String sql = "update member set member_pw = '" + tempPw + "' where member_id = '" + memberId + "'";
		Utility.connect();
		try {
			Utility.rs = Utility.stmt.executeQuery(sql);
			Utility.stmt.executeQuery("commit");
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Utility.disConnect();
		return tempPw;
	}
	
	public boolean updateMember(String option, String memberId, String originalData, String changeData) {
		Member dto = selectOneId(memberId);
		if(option.equals("member_pw") && !dto.getMemberPw().equals(originalData)) {
			return false;
		}
		String sql = "update member set " + option + " = '" + changeData + "' where member_id = '" + memberId + "'";
		Utility.connect();
		try {
			Utility.rs = Utility.stmt.executeQuery(sql);
			Utility.stmt.executeQuery("commit");
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Utility.disConnect();
		return true;
	}
	
	public boolean updateMember() {
		String sql = "update member set grade = '우수' where grade = '일반' and my_amount >= 5";
		Utility.connect();
		try {
			Utility.rs = Utility.stmt.executeQuery(sql);
			Utility.stmt.executeQuery("commit");
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Utility.disConnect();
		return true;
	}
	
	public boolean deleteMember(String memberId, String memberPw) {
		Member dto = selectOneId(memberId);
		if(!dto.getMemberPw().equals(memberPw)) {
			return false;
		}
		String sql = "delete from member where member_id = '" + memberId + "'";
		Utility.connect();
		try {
			Utility.rs = Utility.stmt.executeQuery(sql);
			Utility.stmt.executeQuery("commit");
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Utility.disConnect();
		return true;
	}
	
}
