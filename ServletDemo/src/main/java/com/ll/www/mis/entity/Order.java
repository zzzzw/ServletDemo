package com.ll.www.mis.entity;

import java.sql.Date;

/**
 * 实体类，跟数据表对应，实现get/set
 */

public class Order {

	private Long id;
	/* 乘客姓名 */
	private String name;

	/* 出发时间 */
	private Date startTime;

	/* 价格 */
	private Float price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	
	 
 
 

}
