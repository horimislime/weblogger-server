package jp.horimislime.weblogger.controller;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.horimislime.weblogger.server.service.WebLoggerService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

/**
 * Handle connection with browser extension
 * 
 * @author horimislime
 * 
 */
@Controller
public class ApiController {

	private static Logger logger = Logger.getLogger(ApiController.class.getName());

	@Autowired
	private WebLoggerService webLoggerService;

	/**
	 * Returns total browse count
	 * 
	 * @param req
	 * @param resp
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	@ResponseBody
	public String getCount(HttpServletRequest req, HttpServletResponse resp,
			@RequestParam(required = true) int userId) {

		int count = webLoggerService.getTotalBrowseCount(userId);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(resp.getOutputStream()));
			String response = new Gson().toJson(count);
			logger.info(response);
			writer.write(response);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				logger.error(e);
			}
		}
		return "index";
	}

	/**
	 * Accepts uploading browsing log
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload(@RequestParam(required = true) String time,
			@RequestParam(required = true) String url) {

		Map<String, String> responseJson = new HashMap<String, String>();
		try {
			webLoggerService.insert(0, "", url, new Date(Long.valueOf(time)));
			responseJson.put("status", "success");
			responseJson.put("total", String.valueOf(1));

		} catch (Exception e) {
			e.printStackTrace();
			responseJson.put("status", "error");
		}
		return new Gson().toJson(responseJson);
	}
}