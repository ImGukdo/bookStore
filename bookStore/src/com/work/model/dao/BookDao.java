package com.work.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.work.model.dto.Book;
import com.work.model.service.MemberService;

public class BookDao {

	public boolean addBook(Book dto) {
		Utility.connect();
		String sql = "insert into book values(SEQ_BOOK.NEXTVAL, '" + dto.getBookName() + "', '" +
		dto.getBookWriter() + "', '" + dto.getBookCompany() + "', " + dto.getBookPrice() + ", " +
		dto.getBookAmount() + ", '" + dto.getBookDate() + "', '" + dto.getBookContent() + "')";
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
	
	public ArrayList<Book> selectList(){
		ArrayList<Book> list = new ArrayList<Book>();
		Utility.connect();
		
		// 4. SQL수행요청
		try {
			Utility.rs = Utility.stmt.executeQuery("select * from book");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 5. 결과처리
		try {
			while(Utility.rs.next()) {
				Book dto = new Book();
				dto.setBookNum(Utility.rs.getInt("book_no"));
				dto.setBookName(Utility.rs.getString("book_name"));
				dto.setBookWriter(Utility.rs.getString("book_writer"));
				dto.setBookCompany(Utility.rs.getString("book_company"));
				dto.setBookPrice(Utility.rs.getInt("book_price"));
				dto.setBookAmount(Utility.rs.getInt("book_amount"));
				dto.setBookDate(Utility.rs.getString("book_date"));
				dto.setBookContent(Utility.rs.getString("book_content"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Utility.disConnect();
	
		return list;
	}

	public ArrayList<Book> selectList(String BookName){
		ArrayList<Book> list = new ArrayList<Book>();
		Utility.connect();
		String sql = "select * from book where book_name like '%" + BookName + "%'";
		
		// 4. SQL수행요청
		try {
			Utility.rs = Utility.stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 5. 결과처리
		try {
			while(Utility.rs.next()) {
				Book dto = new Book();
				dto.setBookNum(Utility.rs.getInt("book_no"));
				dto.setBookName(Utility.rs.getString("book_name"));
				dto.setBookWriter(Utility.rs.getString("book_writer"));
				dto.setBookCompany(Utility.rs.getString("book_company"));
				dto.setBookPrice(Utility.rs.getInt("book_price"));
				dto.setBookAmount(Utility.rs.getInt("book_amount"));
				dto.setBookDate(Utility.rs.getString("book_date"));
				dto.setBookContent(Utility.rs.getString("book_content"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Utility.disConnect();
	
		return list;
	}

	public Book selectOneNum(int bookNum) {
		String sql = "select * from book where book_no = " + bookNum;
		Utility.connect();
		try {
			Utility.rs = Utility.stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Book dto = null;
		try {
			if(Utility.rs.next()) {
				dto = new Book();
				dto.setBookNum(Utility.rs.getInt("book_no"));
				dto.setBookName(Utility.rs.getString("book_name"));
				dto.setBookWriter(Utility.rs.getString("book_writer"));
				dto.setBookCompany(Utility.rs.getString("book_company"));
				dto.setBookPrice(Utility.rs.getInt("book_price"));
				dto.setBookAmount(Utility.rs.getInt("book_amount"));
				dto.setBookDate(Utility.rs.getString("book_date"));
				dto.setBookContent(Utility.rs.getString("book_content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Utility.disConnect();
		}
		Utility.disConnect();
		return dto;
	}
	
	
	public boolean updateBook(String option, int bookNum, String changeData) {
		String sql = "update book set " + option + " = '" + changeData + "' where book_no = " + bookNum;
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
	
	public boolean deleteBook(int bookNum, String memberPw) {
		if(!MemberService.getDao().selectOneId(MemberService.getMemberId()).getMemberPw().equals(memberPw)) {
			return false;
		}
		String sql = "delete from book where book_no = " + bookNum;
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
