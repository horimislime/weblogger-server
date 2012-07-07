package jp.horimislime.weblogger.server.service;

import java.util.Date;
import java.util.Map;

/**
 * Service interface for access to weblog
 * 
 * @author horimislime
 * 
 */
public interface WebLoggerService {

	/**
	 * Insert web browsing info into db
	 * 
	 * @param log
	 */
	public void insert(int userid, String title, String url, Date date);

	/**
	 * Get count of logs
	 * 
	 * @param userId
	 * @return
	 */
	int getTotalBrowseCount(int userId);

	/**
	 * Get browse count for each day
	 * 
	 * @param userId
	 * @return
	 */
	Map<String, Long> getDailyBrowseCount(int userId);

}
