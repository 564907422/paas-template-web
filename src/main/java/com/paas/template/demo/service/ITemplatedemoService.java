package com.paas.template.demo.service;

import com.github.pagehelper.PageInfo;
import com.paas.template.demo.model.Templatedemo;
//import com.bbtree.framework.page.PaginationSupport;

public interface ITemplatedemoService {

    void save(Templatedemo record);

    void update(Templatedemo record);

    PageInfo<Templatedemo> queryPage(Templatedemo record, int currentPage, int pageSize);

    Templatedemo selectById(Integer id);


}
