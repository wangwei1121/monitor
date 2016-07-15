package com.skysea.monitor.domain;

import java.io.Serializable;

import com.skysea.monitor.domain.support.BaseDomain;


public class MonitorInstanceLogText extends BaseDomain implements Serializable {

	private static final long serialVersionUID = -1L;

	private Integer id;
	
	private Integer monitorInstanceLogId;
	
	private String receivedContent;
	
	public MonitorInstanceLogText() {

	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getMonitorInstanceLogId() {
		return monitorInstanceLogId;
	}
	
	public void setMonitorInstanceLogId(Integer monitorInstanceLogId) {
		this.monitorInstanceLogId = monitorInstanceLogId;
	}
	
	public String getReceivedContent() {
		return receivedContent;
	}
	
	public void setReceivedContent(String receivedContent) {
		this.receivedContent = receivedContent;
	}
	
}