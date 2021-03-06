package jp.horimislime.weblogger.server.db;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Log {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column log.id
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	private Long id;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column log.userid
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	private Integer userid;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column log.url
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	private String url;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column log.title
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	private String title;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column log.insert_datetime
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	private Date insertDateTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column log.access_datetime
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	private Date accessDatetime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column log.id
	 * 
	 * @return the value of log.id
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column log.id
	 * 
	 * @param id
	 *            the value for log.id
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column log.userid
	 * 
	 * @return the value of log.userid
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	public Integer getUserid() {
		return userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column log.userid
	 * 
	 * @param userid
	 *            the value for log.userid
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column log.url
	 * 
	 * @return the value of log.url
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column log.url
	 * 
	 * @param url
	 *            the value for log.url
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column log.title
	 * 
	 * @return the value of log.title
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column log.title
	 * 
	 * @param title
	 *            the value for log.title
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column log.insert_datetime
	 * 
	 * @return the value of log.insert_datetime
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	public Date getInsertDateTime() {
		return insertDateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column log.insert_datetime
	 * 
	 * @param insertDateTime
	 *            the value for log.insert_datetime
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	public void setInsertDateTime(Date insertDateTime) {
		this.insertDateTime = insertDateTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column log.access_datetime
	 * 
	 * @return the value of log.access_datetime
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	public Date getAccessDatetime() {
		return accessDatetime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column log.access_datetime
	 * 
	 * @param accessDatetime
	 *            the value for log.access_datetime
	 * 
	 * @mbggenerated Sat Jul 07 12:14:46 JST 2012
	 */
	public void setAccessDatetime(Date accessDatetime) {
		this.accessDatetime = accessDatetime;
	}

	public Log() {
		super();
	}

	public Log(int userid, String title, String url, Date accessDate) {
		this.userid = userid;
		this.title = title;
		this.url = url;
		this.accessDatetime = accessDate;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("id", id).append("userid", userid)
				.append("url", url).append("title", title)
				.append("insert_datetime", insertDateTime).append("accessDatetime", accessDatetime)
				.toString();
	}
}