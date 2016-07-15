package com.skysea.monitor.domain;

import java.io.Serializable;
import java.util.Date;

import com.skysea.monitor.domain.support.BaseDomain;


public class MonitorInstanceLog extends BaseDomain implements Serializable {

	private static final long serialVersionUID = -1L;

	private Integer id;
	
	private Integer monitorInstanceId;
	
	private Integer connTime;
	
	private Integer receivedSize;
	
	private Date createTime;
	
	public MonitorInstanceLog() {

	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getMonitorInstanceId() {
		return monitorInstanceId;
	}
	
	public void setMonitorInstanceId(Integer monitorInstanceId) {
		this.monitorInstanceId = monitorInstanceId;
	}
	
	public Integer getConnTime() {
		return connTime;
	}
	
	public void setConnTime(Integer connTime) {
		this.connTime = connTime;
	}
	
	public Integer getReceivedSize() {
		return receivedSize;
	}
	
	public void setReceivedSize(Integer receivedSize) {
		this.receivedSize = receivedSize;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}