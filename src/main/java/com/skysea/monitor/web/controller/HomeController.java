package com.skysea.monitor.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController extends BaseController {

	@RequestMapping({ "/home" })
	public ModelAndView home() {
		return new ModelAndView("home");
	}
}
