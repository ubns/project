package model.beans;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
	private int id;
	private String name;
	private String pass;
	private Date createDate;
	private Date updateDate;
	
	public User() {
		
	}
	
	public User(String name,String pass, Date createDate, Date updateDate) {
		this.name = name;
		this.pass = pass;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
