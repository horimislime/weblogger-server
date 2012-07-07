package jp.horimislime.weblogger.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestInterceptor extends HandlerInterceptorAdapter {

	private static Logger logger = Logger.getLogger(RequestInterceptor.class.getName());

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) {
		logger.info("[From " + req.getRemoteAddr() + "] Request to " + req.getRequestURI());
		resp.setHeader("Access-Control-Allow-Origin", "*");
		return true;
	}
}
