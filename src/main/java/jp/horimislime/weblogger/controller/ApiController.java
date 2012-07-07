package jp.horimislime.weblogger.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URLDecoder;
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
import com.google.gson.reflect.TypeToken;

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
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest req, HttpServletResponse resp) {

		BufferedReader reader = null;
		Map<String, String> responseJson = new HashMap<String, String>();

		try {
			reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
			String log = new String(), line = null;

			while ((line = reader.readLine()) != null) {
				log += line;
			}
			if (log.length() == 0) {
				throw new Exception("JSON is empty.");
			}
			log = URLDecoder.decode(log, "UTF-8");
			logger.info(log);

			Map<String, String> json = new Gson().fromJson(log,
					new TypeToken<HashMap<String, String>>() {
					}.getType());

			webLoggerService.insert(Integer.parseInt(json.get("userid")), json.get("title"),
					json.get("url"), new Date(Long.valueOf(json.get("time"))));

			responseJson.put("status", "success");
			responseJson.put("total", String.valueOf(1));

		} catch (Exception e) {
			e.printStackTrace();
			responseJson.put("status", "error");

		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				logger.error(e);
			}
		}
		return new Gson().toJson(responseJson);
	}
}