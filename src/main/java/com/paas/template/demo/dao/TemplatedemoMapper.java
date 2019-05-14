package com.paas.template.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.paas.template.demo.model.Templatedemo;
//import com.bbtree.framework.page.PaginationSupport;

public interface TemplatedemoMapper {
	
	int insert(Templatedemo record);
	
	int deleteById(Integer id);

	int updateById(Templatedemo record);

	Templatedemo selectById(Integer id);

	List<Templatedemo> queryPage(@Param("vo") Templatedemo record);
}