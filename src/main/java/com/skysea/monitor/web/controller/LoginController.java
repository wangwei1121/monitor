package com.skysea.monitor.web.controller;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.CookieGenerator;
import org.springframework.web.util.WebUtils;

import com.skysea.monitor.domain.UserInfo;
import com.skysea.monitor.service.UserInfoService;
import com.skysea.monitor.util.MD5Util;
import com.skysea.monitor.web.Keys;


@RestController
public class LoginController extends BaseController{
	
	private static final String DEFAULT_PASSWORD = "...@.#...";
	
	private int cookieAge = 7*24*3600;
	
	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping({ "/loginError"})
	public ModelAndView loginError(ModelAndView moderView,
							   @RequestParam(value="type",required=false) String type,
							   @RequestParam(value="backUrl",required=false) String backUrl,
							   HttpServletRequest request,HttpServletResponse response) {
			moderView.setViewName("login");
			moderView.addObject("backUrl", backUrl);
			moderView.addObject("loginError", super.getMessage(request,"login.signin"));
			return moderView;
	}
	
	@RequestMapping({ "/login"})
	public ModelAndView login(ModelAndView moderView,
							   @RequestParam(value="type",required=false) String type,
							   @RequestParam(value="backUrl",required=false) String backUrl,
							   HttpServletRequest request,HttpServletResponse response) {
		moderView.setViewName("login");
		return moderView;
	}
	
	@RequestMapping({ "/signIn"})
	public ModelAndView signIn(@RequestParam(value="loginName",required=false) String loginName,
							   @RequestParam(value="password",required=false) String password,
							   @RequestParam(value="isRemember",required=false) String isRemember,
							   HttpServletRequest request,HttpServletResponse response) {
		try{
			if(StringUtils.isBlank(loginName)){
				String errorMsg = super.getMessage(request,"login.failed.username.isEmpty");
				if("get".equalsIgnoreCase(request.getMethod())){
					super.renderJavaScript(response,"window.onload=function(){alert('" + errorMsg + "');history.back()}");
					return null;
				}
				super.renderJson(response,"{\"errorMsg\":\""+ errorMsg + "\"}");
				return null;
			}
			if(StringUtils.isBlank(password)){
				String errorMsg = super.getMessage(request,"login.failed.password.isEmpty");
				if("get".equalsIgnoreCase(request.getMethod())){
					super.renderJavaScript(response,"window.onload=function(){alert('" + errorMsg + "');history.back()}");
					return null;
				}
				super.renderJson(response,"{\"errorMsg\":\""+ errorMsg + "\"}");
				return null;
			}
			UserInfo user = new UserInfo();
			user.setUserName(loginName);
			List<UserInfo> list = this.userInfoService.getList(user);
			if (null == list || list.size() == 0) {
				String errorMsg = super.getMessage(request,"login.failed.username.invalid");
				if("get".equalsIgnoreCase(request.getMethod())){
					super.renderJavaScript(response,"window.onload=function(){alert('" + errorMsg + "');history.back()}");
					return null;
				}
				super.renderJson(response,"{\"errorMsg\":\""+ errorMsg + "\"}");
				return null;
			}
			
			Cookie passwordCookie = WebUtils.getCookie(request, Keys.PASSWORD);
			if(null != passwordCookie && DEFAULT_PASSWORD.equals(password)) {
				user.setPassword(passwordCookie.getValue());
			}else{
				user.setPassword(MD5Util.MD5Encode(password));
			}
			list = this.userInfoService.getList(user);
			if (null == list || list.size() == 0) {
				String errorMsg = super.getMessage(request,"login.failed.password.invalid");
				if("get".equalsIgnoreCase(request.getMethod())){
					super.renderJavaScript(response,"window.onload=function(){alert('" + errorMsg + "');history.back()}");
					return null;
				}
				super.renderJson(response,"{\"errorMsg\":\""+ errorMsg + "\"}");
				return null;
			}
			if(list.size() > 1){
				String errorMsg = super.getMessage(request,"login.failed.username.repeat");
				if("get".equalsIgnoreCase(request.getMethod())){
					super.renderJavaScript(response,"window.onload=function(){alert('" + errorMsg + "');history.back()}");
					return null;
				}
				super.renderJson(response,"{\"errorMsg\":\""+ errorMsg + "\"}");
				return null;
			}
			super.setSessionUser(request,list.get(0));
			
			CookieGenerator cg = new CookieGenerator();
			if (isRemember != null) {
				cg.setCookieMaxAge(cookieAge);
				cg.setCookieName(Keys.LOGIN_NAME);
				cg.addCookie(response, URLEncoder.encode(loginName, "UTF-8"));
				cg.setCookieName(Keys.PASSWORD);
				cg.addCookie(response, URLEncoder.encode(list.get(0).getPassword(), "UTF-8"));
				cg.setCookieName("isRemember");
				cg.addCookie(response, URLEncoder.encode(isRemember, "UTF-8"));
			} else {
				cg.setCookieMaxAge(0);
				cg.setCookieName(Keys.LOGIN_NAME);
				cg.removeCookie(response);
				cg.setCookieName(Keys.PASSWORD);
				cg.removeCookie(response);
				cg.setCookieName("isRemember");
				cg.removeCookie(response);
			}
			if("get".equalsIgnoreCase(request.getMethod())){
				return new ModelAndView("redirect:/home");
			}
			super.renderJson(response,"{\"errorMsg\":\"\"}");
			return null;
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping({ "/signOut"})
	public ModelAndView signOut(HttpServletRequest request) {
		request.getSession().removeAttribute(Keys.SESSION_USERINFO_KEY);
		return new ModelAndView("redirect:/login");
	}
}