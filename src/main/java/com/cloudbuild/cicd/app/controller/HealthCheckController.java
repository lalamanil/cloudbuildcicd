package com.cloudbuild.cicd.app.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class HealthCheckController {

	private static final Logger LOGGER = Logger.getLogger(HealthCheckController.class.getName());

	@RequestMapping(value = "/healthCheck", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> healthCheck() {
		LOGGER.info("I am in HealthCheckController");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("health check status", "sucess");
		map.put("statusCode", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	

}
