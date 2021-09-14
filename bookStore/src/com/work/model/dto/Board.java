package com.work.model.dto;

public class Board {

	private int boardNum;
	private String boardTitle;
	private String boardDate;
	private String boardWriter;
	private String boardContent;
	
	public Board() {
	}

	/**
	 * @param boardNum
	 * @param boardTitle
	 * @param boardDate
	 * @param boardWriter
	 * @param boardContent
	 */
	public Board(int boardNum, String boardTitle, String boardDate, String boardWriter, String boardContent) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardDate = boardDate;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
	}

	/**
	 * @return the boardNum
	 */
	public int getBoardNum() {
		return boardNum;
	}

	/**
	 * @param boardNum the boardNum to set
	 */
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	/**
	 * @return the boardTitle
	 */
	public String getBoardTitle() {
		return boardTitle;
	}

	/**
	 * @param boardTitle the boardTitle to set
	 */
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	/**
	 * @return the boardDate
	 */
	public String getBoardDate() {
		return boardDate;
	}

	/**
	 * @param boardDate the boardDate to set
	 */
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	/**
	 * @return the boardWriter
	 */
	public String getBoardWriter() {
		return boardWriter;
	}

	/**
	 * @param boardWriter the boardWriter to set
	 */
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	/**
	 * @return the boardContent
	 */
	public String getBoardContent() {
		return boardContent;
	}

	/**
	 * @param boardContent the boardContent to set
	 */
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("글번호 : ");
		builder.append(boardNum);
		builder.append(", ");
		builder.append("작성자 : ");
		builder.append(boardWriter);
		builder.append(", ");
		builder.append("작성일 : ");
		builder.append(boardDate);
		builder.append("\n");
		builder.append("글제목 : ");
		builder.append(boardTitle);
		builder.append("\n");
		builder.append(boardContent);
		return builder.toString();
	}
	
}
