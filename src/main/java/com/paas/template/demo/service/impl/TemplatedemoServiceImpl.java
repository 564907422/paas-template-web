package com.paas.template.demo.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paas.template.demo.dao.TemplatedemoMapper;
import com.paas.template.demo.model.Templatedemo;
import com.paas.template.demo.service.ITemplatedemoService;

/**
 * 事务管理层，每个方法应该尽量简洁，执行时间短
 */
@Service
public class TemplatedemoServiceImpl implements ITemplatedemoService {

    @Autowired
    private TemplatedemoMapper demoMapper;

    @Override
    @Transactional(readOnly = false)
    public void save(Templatedemo record) {
        demoMapper.insert(record);
    }

    @Override
    @Transactional(readOnly = true)
    public PageInfo<Templatedemo> queryPage(Templatedemo record, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<Templatedemo> suppliers = demoMapper.queryPage(record);
        PageInfo<Templatedemo> pageInfo = new PageInfo<>(suppliers);
        return pageInfo;
    }

    @Override
    @Transactional(readOnly = true)
    public Templatedemo selectById(Integer id) {
        return demoMapper.selectById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Templatedemo record) {
        demoMapper.updateById(record);
    }


}
