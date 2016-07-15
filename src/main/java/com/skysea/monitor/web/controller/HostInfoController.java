package com.skysea.monitor.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.skysea.monitor.domain.HostInfo;
import com.skysea.monitor.service.HostInfoService;
import com.skysea.monitor.web.entity.UIResult;

@RestController
public class HostInfoController extends BaseController{
	
	@Autowired
	private HostInfoService hostInfoService;

	@RequestMapping(value = "/hostInfo/list")
	public UIResult list() {
		UIResult result = new UIResult();
		try{
			List<HostInfo> list = this.hostInfoService.getList(null);
			if(null != list && list.size() > 0){
				result.setResult(list);
				result.setTotalCount(list.size());
			}
		}catch(Exception e){
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		
		return result;
	}

	@RequestMapping(value = "/hostInfo/add")
	public ModelAndView add() {
		ModelAndView modelView = new ModelAndView("hostInfo/add");
		return modelView;
	}
	
	@RequestMapping(value = "/hostInfo/save")
	public UIResult save(HostInfo entity) {
		UIResult result = new UIResult();
		try {
			if(null == entity || null == entity.getIp() || null == entity.getPort() || null == entity.getName()){
				result.setMessage("entity is null");
				return result;
			}else{
				Date now = new Date();
				if(null != entity.getId()){
					entity.setUpdateTime(now);
					this.hostInfoService.update(entity);
					result.setResult("update success");	
				}else{
					entity.setCreateTime(now);
					this.hostInfoService.insert(entity);
					result.setResult("insert success");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value = "/hostInfo/edit/{id}")
	public UIResult edit(@PathVariable Integer id) {
		UIResult result = new UIResult();
		try {
			HostInfo entity = new HostInfo();
			entity.setId(id);
			entity = this.hostInfoService.get(entity);
			if(null == entity){
				result.setMessage("entity is null by id " + id);
			}else{
				result.setResult(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value = "/hostInfo/delete")
	public ModelAndView delete() {
		ModelAndView modelView = new ModelAndView("hostInfo/delete");
		return modelView;
	}
}