package com.work.model.dto;

public class Member {
	private String memberId;
	private String memberPw;
	private String name;
	private String mobile;
	private String email;
	private String entryDate;
	private String grade;
	private int myAmount;
	
	public Member() {
	}

	/**
	 * @param memberId  아이디
	 * @param memberPw  비밀번호
	 * @param name  이름
	 * @param mobile  핸드폰번호
	 * @param email  이메일
	 * @param entryData  가입날짜
	 * @param grade  등급
	 * @param myAmount  누적구매수
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.entryDate = null;
		this.grade = "일반";
		this.myAmount = 0;
	}

	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, int myAmount) {
		this(memberId, memberPw, name, mobile, email);
		this.entryDate = null;
		this.grade = grade;
		this.myAmount = myAmount;
	}

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the memberPw
	 */
	public String getMemberPw() {
		return memberPw;
	}

	/**
	 * @param memberPw the memberPw to set
	 */
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the entryDate
	 */
	public String getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the myAmount
	 */
	public int getMyAmount() {
		return myAmount;
	}

	/**
	 * @param myAmount the myAmount to set
	 */
	public void setMyAmount(int myAmount) {
		this.myAmount = myAmount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("아이디 : " + memberId);
		builder.append("\n");
		builder.append("비밀번호 : ");
		builder.append("\n");
		builder.append("이름 : " + name);
		builder.append("\n");
		builder.append("핸드폰번호 : " + mobile);
		builder.append("\n");
		builder.append("이메일 : " + email);
		builder.append("\n");
		builder.append("가입일 : " + entryDate);
		builder.append("\n");
		builder.append("등급 : " + grade);
		builder.append("\n");
		builder.append("누적구매수 : " + myAmount);
		return builder.toString();
	}
	
}
