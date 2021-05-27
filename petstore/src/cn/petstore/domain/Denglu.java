package cn.petstore.domain;

import java.io.Serializable;
import java.util.Date;

public class Denglu implements Serializable {

	private static final long serialVersionUID = 1L;
	private int uid; // 用户编号
	private String username; // 用户名称
	private String ipaddress; // 用户名称
	private Date logintime;// 日志操作时间

	public Date getLogintime() {
		return logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	@Override
	public String toString() {
		return "Denglu [uid=" + uid + ", username=" + username + ", ipaddress=" + ipaddress+", logintime=" + logintime + "]";
	}

}
