package com.skysea.monitor.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MonitorErrorLogController {

	@RequestMapping(value = "/monitorErrorLog/list")
	public ModelAndView list() {
		ModelAndView modelView = new ModelAndView("monitorErrorLog/list");
		return modelView;
	}

	@RequestMapping(value = "/monitorErrorLog/add")
	public ModelAndView add() {
		ModelAndView modelView = new ModelAndView("monitorErrorLog/add");
		return modelView;
	}
	
	@RequestMapping(value = "/monitorErrorLog/save")
	public ModelAndView save() {
		ModelAndView modelView = new ModelAndView("monitorErrorLog/save");
		return modelView;
	}
	
	@RequestMapping(value = "/monitorErrorLog/update")
	public ModelAndView update() {
		ModelAndView modelView = new ModelAndView("monitorErrorLog/update");
		return modelView;
	}
	
	@RequestMapping(value = "/monitorErrorLog/delete")
	public ModelAndView delete() {
		ModelAndView modelView = new ModelAndView("monitorErrorLog/delete");
		return modelView;
	}
}