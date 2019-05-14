package com.paas.template.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paas.template.demo.dao.TemplatedemoMapper;
import com.paas.template.demo.model.Templatedemo;
import com.paas.template.demo.service.ITemplatedemoService;
//import com.bbtree.framework.page.PaginationSupport;

@Service
public class TemplatedemoServiceImpl implements ITemplatedemoService {

	@Autowired
	private TemplatedemoMapper demoMapper;

	@Override
	@Transactional(readOnly=false)
	public void save(Templatedemo record) {
		demoMapper.insert(record);
	}

//	@Override
//	@Transactional(readOnly=true)
//	public PaginationSupport queryPage(Templatedemo record, PaginationSupport ps) {
//		List<Templatedemo> suppliers = demoMapper.queryPage(ps, record);
//		ps.setItems(suppliers);
//		return ps;
//	}

	@Override
	@Transactional(readOnly=true)
	public Templatedemo selectById(Integer id) {
		return demoMapper.selectById(id);
	}

	@Override
	@Transactional(readOnly=false)
	public void update(Templatedemo record) {
		demoMapper.updateById(record);
	}
	

}
