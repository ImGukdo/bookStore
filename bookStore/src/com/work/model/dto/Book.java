package com.work.model.dto;

public class Book {

	private int bookNum;
	private String bookName;
	private String bookWriter;
	private String bookCompany;
	private int bookPrice;
	private int bookAmount;
	private String bookDate;
	private String bookContent;
	
	public Book() {
	}

	/**
	 * @param bookNum
	 * @param bookName
	 * @param bookWriter
	 * @param bookCompany
	 * @param bookPrice
	 * @param bookAmount
	 * @param bookDate
	 * @param bookContent
	 */
	public Book(int bookNum, String bookName, String bookWriter, String bookCompany, int bookPrice, int bookAmount,
			String bookDate, String bookContent) {
		super();
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.bookCompany = bookCompany;
		this.bookPrice = bookPrice;
		this.bookAmount = bookAmount;
		this.bookDate = bookDate;
		this.bookContent = bookContent;
	}

	/**
	 * @return the bookNum
	 */
	public int getBookNum() {
		return bookNum;
	}

	/**
	 * @param bookNum the bookNum to set
	 */
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the bookWriter
	 */
	public String getBookWriter() {
		return bookWriter;
	}

	/**
	 * @param bookWriter the bookWriter to set
	 */
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	/**
	 * @return the bookCompany
	 */
	public String getBookCompany() {
		return bookCompany;
	}

	/**
	 * @param bookCompany the bookCompany to set
	 */
	public void setBookCompany(String bookCompany) {
		this.bookCompany = bookCompany;
	}

	/**
	 * @return the bookPrice
	 */
	public int getBookPrice() {
		return bookPrice;
	}

	/**
	 * @param bookPrice the bookPrice to set
	 */
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	/**
	 * @return the bookAmount
	 */
	public int getBookAmount() {
		return bookAmount;
	}

	/**
	 * @param bookAmount the bookAmount to set
	 */
	public void setBookAmount(int bookAmount) {
		this.bookAmount = bookAmount;
	}

	/**
	 * @return the bookDate
	 */
	public String getBookDate() {
		return bookDate;
	}

	/**
	 * @param bookDate the bookDate to set
	 */
	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}

	/**
	 * @return the bookContent
	 */
	public String getBookContent() {
		return bookContent;
	}

	/**
	 * @param bookContent the bookContent to set
	 */
	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("책등록번호 : ");
		builder.append(bookNum);
		builder.append(", ");
		builder.append("책이름 : ");
		builder.append(bookName);
		builder.append(", ");
		builder.append("지은이 : ");
		builder.append(bookWriter);
		builder.append(", ");
		builder.append("출판사 : ");
		builder.append(bookCompany);
		builder.append("\n");
		builder.append("책가격 : ");
		builder.append(bookPrice);
		builder.append(", ");
		builder.append("재고 : ");
		builder.append(bookAmount);
		builder.append(", ");
		builder.append("출판일 : ");
		builder.append(bookDate);
		builder.append("\n");
		builder.append("책 줄거리\n");
		builder.append(bookContent);
		return builder.toString();
	}
	
}
