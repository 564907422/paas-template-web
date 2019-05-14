package com.paas.template.demo.manage.impl;

import com.github.pagehelper.PageInfo;
import com.paas.template.demo.manage.ITemplatedemoManage;
import com.paas.template.demo.model.Templatedemo;
import com.paas.template.demo.service.ITemplatedemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ITemplatedemoManageImpl implements ITemplatedemoManage {
    @Autowired
    ITemplatedemoService templatedemoService;

    @Override
    public void save(Templatedemo record) {
        templatedemoService.save(record);
    }

    @Override
    public void update(Templatedemo record) {
        templatedemoService.update(record);
    }

    @Override
    public PageInfo<Templatedemo> queryPage(Templatedemo record, int currentPage, int pageSize) {
        return templatedemoService.queryPage(record, currentPage, pageSize);
    }

    @Override
    public Templatedemo selectById(Integer id) {
        return templatedemoService.selectById(id);
    }
}
