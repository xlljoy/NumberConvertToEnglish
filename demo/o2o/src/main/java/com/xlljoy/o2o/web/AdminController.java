package com.xlljoy.o2o.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin", method = RequestMethod.GET)
public class AdminController {

	@RequestMapping(value = "/conversion")
	public String numberConversion() {
		return "frontend/conversion";
	}
}
