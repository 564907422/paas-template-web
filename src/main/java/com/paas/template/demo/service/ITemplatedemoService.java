package com.paas.template.demo.service;

import com.paas.template.demo.model.Templatedemo;
//import com.bbtree.framework.page.PaginationSupport;

public interface ITemplatedemoService {

	void save(Templatedemo record);

	void update(Templatedemo record);

//	PaginationSupport queryPage(Templatedemo record, PaginationSupport ps);

	Templatedemo selectById(Integer id);


	
}
