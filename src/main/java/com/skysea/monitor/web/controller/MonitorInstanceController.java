package com.skysea.monitor.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MonitorInstanceController {

	@RequestMapping(value = "/monitorInstance/list")
	public ModelAndView list() {
		ModelAndView modelView = new ModelAndView("monitorInstance/list");
		return modelView;
	}

	@RequestMapping(value = "/monitorInstance/add")
	public ModelAndView add() {
		ModelAndView modelView = new ModelAndView("monitorInstance/add");
		return modelView;
	}
	
	@RequestMapping(value = "/monitorInstance/save")
	public ModelAndView save() {
		ModelAndView modelView = new ModelAndView("monitorInstance/save");
		return modelView;
	}
	
	@RequestMapping(value = "/monitorInstance/update")
	public ModelAndView update() {
		ModelAndView modelView = new ModelAndView("monitorInstance/update");
		return modelView;
	}
	
	@RequestMapping(value = "/monitorInstance/delete")
	public ModelAndView delete() {
		ModelAndView modelView = new ModelAndView("monitorInstance/delete");
		return modelView;
	}
}