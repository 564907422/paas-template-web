package com.paas.template.demo.manage;

import com.github.pagehelper.PageInfo;
import com.paas.template.demo.model.Templatedemo;

public interface ITemplatedemoManage {
    void save(Templatedemo record);

    void update(Templatedemo record);

    PageInfo<Templatedemo> queryPage(Templatedemo record, int currentPage, int pageSize);

    Templatedemo selectById(Integer id);

}
