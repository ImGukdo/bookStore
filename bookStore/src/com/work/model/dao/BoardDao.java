package com.work.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.work.model.dto.Board;
import com.work.model.service.MemberService;

public class BoardDao {

	
	public boolean addBoard(Board dto) {
		Utility.connect();
		String sql = "insert into board values(SEQ_BOARD.NEXTVAL, '" + dto.getBoardTitle() + "', '" +
		dto.getBoardDate() + "', '" + dto.getBoardWriter() + "', '" + dto.getBoardContent() + "')";
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
	
	public ArrayList<Board> selectList(){
		ArrayList<Board> list = new ArrayList<Board>();
		Utility.connect();
		
		// 4. SQL수행요청
		try {
			Utility.rs = Utility.stmt.executeQuery("select * from board order by board_no desc");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 5. 결과처리
		try {
			while(Utility.rs.next()) {
				Board dto = new Board();
				dto.setBoardNum(Utility.rs.getInt("board_no"));
				dto.setBoardTitle(Utility.rs.getString("board_title"));
				dto.setBoardDate(Utility.rs.getString("board_date"));
				dto.setBoardWriter(Utility.rs.getString("board_writer"));
				dto.setBoardContent(Utility.rs.getString("board_content"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Utility.disConnect();
	
		return list;
	}

	public ArrayList<Board> selectList(String BoardTitle){
		ArrayList<Board> list = new ArrayList<Board>();
		Utility.connect();
		String sql = "select * from board where board_title like '%" + BoardTitle + "%' order by board_no desc";
		
		// 4. SQL수행요청
		try {
			Utility.rs = Utility.stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 5. 결과처리
		try {
			while(Utility.rs.next()) {
				Board dto = new Board();
				dto.setBoardNum(Utility.rs.getInt("board_no"));
				dto.setBoardTitle(Utility.rs.getString("board_title"));
				dto.setBoardDate(Utility.rs.getString("board_date"));
				dto.setBoardWriter(Utility.rs.getString("board_writer"));
				dto.setBoardContent(Utility.rs.getString("board_content"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Utility.disConnect();
	
		return list;
	}

	
	public ArrayList<Board> selectListWriter(String BoardWriter){
		ArrayList<Board> list = new ArrayList<Board>();
		Utility.connect();
		String sql = "select * from board where board_writer = '" + BoardWriter + "' order by board_no desc";
		
		// 4. SQL수행요청
		try {
			Utility.rs = Utility.stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 5. 결과처리
		try {
			while(Utility.rs.next()) {
				Board dto = new Board();
				dto.setBoardNum(Utility.rs.getInt("board_no"));
				dto.setBoardTitle(Utility.rs.getString("board_title"));
				dto.setBoardDate(Utility.rs.getString("board_date"));
				dto.setBoardWriter(Utility.rs.getString("board_writer"));
				dto.setBoardContent(Utility.rs.getString("board_content"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Utility.disConnect();
	
		return list;
	}

	
	public Board selectOneNum(int boardNum) {
		String sql = "select * from board where board_no = " + boardNum;
		Utility.connect();
		try {
			Utility.rs = Utility.stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Board dto = null;
		try {
			if(Utility.rs.next()) {
				dto = new Board();
				dto.setBoardNum(Utility.rs.getInt("board_no"));
				dto.setBoardTitle(Utility.rs.getString("board_title"));
				dto.setBoardDate(Utility.rs.getString("board_date"));
				dto.setBoardWriter(Utility.rs.getString("board_writer"));
				dto.setBoardContent(Utility.rs.getString("board_content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Utility.disConnect();
		return dto;
	}
	
	public boolean deleteBoard(int boardNum, String memberPw) {
		if(!MemberService.getDao().selectOneId(MemberService.getMemberId()).getMemberPw().equals(memberPw)) {
			return false;
		}
		String sql = "delete from board where board_no = " + boardNum;
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
	
	public boolean updateBoard(String option, int boardNum, String changeData) {
		String sql1 = "update board set " + option + " = '" + changeData + "' where board_no = " + boardNum;
		String sql2 = "update board set board_date = '" + Utility.getCurrentDate() + "' where board_no = " + boardNum;
		Utility.connect();
		try {
			Utility.rs = Utility.stmt.executeQuery(sql1);
			Utility.rs = Utility.stmt.executeQuery(sql2);
			Utility.stmt.executeQuery("commit");
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Utility.disConnect();
		return true;
	}
}
