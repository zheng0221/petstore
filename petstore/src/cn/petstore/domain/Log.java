package cn.petstore.domain;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {

	private static final long serialVersionUID = 1L;
	private int uid; // 用户编号
	private String content; // 日志内容
	private Date logtime;// 日志操作时间

	public Date getLogtime() {
		return logtime;
	}

	public void setLogtime(Date logtime) {
		this.logtime = logtime;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Log [uid=" + uid + ", content=" + content + ", logtime=" + logtime + "]";
	}

}
