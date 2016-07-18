package com.skysea.monitor.web.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skysea.monitor.domain.HostInfo;
import com.skysea.monitor.service.HostInfoService;
import com.skysea.monitor.web.entity.UIResult;

@RestController
public class HostInfoController extends BaseController{
	
	@Autowired
	private HostInfoService hostInfoService;

	@RequestMapping(value = "/hostInfo/list")
	public UIResult list(HttpServletRequest request, HttpServletResponse response) {
		UIResult result = new UIResult();
		try{
			List<HostInfo> list = this.hostInfoService.getList(null);
			if(null != list && list.size() > 0){
				result.setResult(list);
				result.setTotalCount(list.size());
			}
			String callback = request.getParameter("callback");
			ObjectMapper mapper = new ObjectMapper();
//			response.setHeader("Access-Control-Allow-Origin", "*");
//			response.setHeader("Access-Control-Allow-Methods", "POST");
//			response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
			super.renderJson(response, callback+"(" + mapper.writeValueAsString(result) +");" );
		}catch(Exception e){
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return null;
	}

	@RequestMapping(value = "/hostInfo/add")
	public ModelAndView add() {
		ModelAndView modelView = new ModelAndView("hostInfo/add");
		return modelView;
	}
	
	@RequestMapping(value = "/hostInfo/save")
	public UIResult save(HostInfo entity,HttpServletRequest request, HttpServletResponse response) {
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
					HostInfo hostInfo = new HostInfo();
					hostInfo.setName(entity.getName());
					Integer count = this.hostInfoService.getCount(hostInfo);
					if(count > 0){
						result.setMessage(entity.getName() + " have exists");
					}else{
						entity.setCreateTime(now);
						this.hostInfoService.insert(entity);
						result.setResult("insert success");
					}
				}
			}
			String callback = request.getParameter("callback");
			ObjectMapper mapper = new ObjectMapper();
//			response.setHeader("Access-Control-Allow-Origin", "*");
//			response.setHeader("Access-Control-Allow-Methods", "POST");
//			response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
			super.renderJson(response, callback+"(" + mapper.writeValueAsString(result) +");" );
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value = "/hostInfo/get/{id}")
	public UIResult get(@PathVariable Integer id,HttpServletRequest request, HttpServletResponse response) {
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
			String callback = request.getParameter("callback");
			ObjectMapper mapper = new ObjectMapper();
//			response.setHeader("Access-Control-Allow-Origin", "*");
//			response.setHeader("Access-Control-Allow-Methods", "POST");
//			response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
			super.renderJson(response, callback+"(" + mapper.writeValueAsString(result) +");" );
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value = "/hostInfo/delete/{id}")
	public ModelAndView delete(@PathVariable Integer id,HttpServletRequest request, HttpServletResponse response) {
		UIResult result = new UIResult();
		try {
			HostInfo entity = new HostInfo();
			entity.setId(id);
			this.hostInfoService.delete(entity);
			String callback = request.getParameter("callback");
			ObjectMapper mapper = new ObjectMapper();
//			response.setHeader("Access-Control-Allow-Origin", "*");
//			response.setHeader("Access-Control-Allow-Methods", "POST");
//			response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
			super.renderJson(response, callback+"(" + mapper.writeValueAsString(result) +");" );
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
		}
		return null;
	}
}