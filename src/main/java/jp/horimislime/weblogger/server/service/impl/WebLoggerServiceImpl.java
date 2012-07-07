package jp.horimislime.weblogger.server.service.impl;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jp.horimislime.weblogger.server.db.Log;
import jp.horimislime.weblogger.server.db.LogExample;
import jp.horimislime.weblogger.server.db.mapper.LogMapper;
import jp.horimislime.weblogger.server.service.WebLoggerService;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class WebLoggerServiceImpl implements WebLoggerService {

	@Autowired
	private LogMapper logMapper;

	@Override
	public void insert(int userId, String title, String url, Date date) {
		Log log = new Log(userId, title, url, date);
		logMapper.insert(log);
	}

	@Override
	public int getTotalBrowseCount(int userId) {
		LogExample example = new LogExample();
		example.createCriteria().andUseridEqualTo(userId);
		return logMapper.countByExample(example);
	}

	@Override
	public Map<String, Long> getDailyBrowseCount(int userId) {
		List<Map<String, Object>> queryResult = logMapper.countByDay(userId);
		LinkedHashMap<String, Long> dataSet = new LinkedHashMap<String, Long>();

		if (CollectionUtils.isEmpty(queryResult)) {
			return dataSet;
		}

		for (Map<String, Object> elem : queryResult) {
			dataSet.put((String) elem.get("access_date"), (Long) elem.get("count"));
		}

		return dataSet;
	}
}
