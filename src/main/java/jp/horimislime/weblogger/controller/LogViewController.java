package jp.horimislime.weblogger.controller;

import java.util.ArrayList;
import java.util.Map;

import jp.horimislime.weblogger.server.service.WebLoggerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Log viewer
 * 
 * @author horimislime
 * 
 */
@Controller
public class LogViewController {

	@Autowired
	private WebLoggerService webLoggerService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String view(Model model) {

		// TODO:select ID
		Map<String, Long> dataSet = webLoggerService.getDailyBrowseCount(0);

		model.addAttribute("keys", new ArrayList<String>(dataSet.keySet()));
		model.addAttribute("values", dataSet.values());
		return "index";
	}
}
