package com.paas.template.demo.service;

import com.github.pagehelper.PageInfo;
import com.paas.framework.db.DataSource;
import com.paas.template.demo.model.Templatedemo;

public interface ITemplatedemoService {

    void save(Templatedemo record);

    void update(Templatedemo record);

    @DataSource("slave")
    PageInfo<Templatedemo> queryPage(Templatedemo record, int currentPage, int pageSize);

    Templatedemo selectById(Integer id);


}
