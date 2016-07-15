package com.skysea.monitor.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MonitorInstanceLogController {

	@RequestMapping(value = "/monitorInstanceLog/list")
	public ModelAndView list() {
		ModelAndView modelView = new ModelAndView("monitorInstanceLog/list");
		return modelView;
	}

	@RequestMapping(value = "/monitorInstanceLog/add")
	public ModelAndView add() {
		ModelAndView modelView = new ModelAndView("monitorInstanceLog/add");
		return modelView;
	}
	
	@RequestMapping(value = "/monitorInstanceLog/save")
	public ModelAndView save() {
		ModelAndView modelView = new ModelAndView("monitorInstanceLog/save");
		return modelView;
	}
	
	@RequestMapping(value = "/monitorInstanceLog/update")
	public ModelAndView update() {
		ModelAndView modelView = new ModelAndView("monitorInstanceLog/update");
		return modelView;
	}
	
	@RequestMapping(value = "/monitorInstanceLog/delete")
	public ModelAndView delete() {
		ModelAndView modelView = new ModelAndView("monitorInstanceLog/delete");
		return modelView;
	}
}