package com.paas.template.demo.controller;


import java.util.Map;

import com.paas.template.demo.manage.ITemplatedemoManage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.paas.framework.constants.DefaultCodeEnum;
import com.paas.framework.vo.RspVo;

import com.paas.template.demo.vo.DataVo;
import com.paas.template.demo.vo.UuidDataVo;

@Controller
@RequestMapping("/demo")
@Api(description = "API描述")
public class TemplatedemoController {

    private static Logger logger = LoggerFactory.getLogger(TemplatedemoController.class);

    @Autowired
    ITemplatedemoManage demoManage;

    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "query", httpMethod = "GET", notes = "query by name", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({@ApiImplicitParam(required = true, name = "name", value = "名字", paramType = "query", dataType = "String")})
    public RspVo query(String name) {
        logger.debug(" ======>>>>>>>>> /demo/query--{}---------", name);
        return RspVo.success(demoManage.selectById(1));
    }

    //自动加解密
    @ResponseBody
    @RequestMapping(value = "/crypt", method = RequestMethod.POST)
    @ApiOperation(value = "crypt", httpMethod = "POST", notes = "自动加解密", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({@ApiImplicitParam(required = true, name = "data", value = "加密参数", paramType = "body", dataType = "Map")})
    public RspVo crypt(@RequestBody Map<String, Object> data) {
        logger.debug(" ======>>>>>>>>> /demo/crypt-----{}-----", data);
        RspVo vo = new RspVo();
        vo.setCode(DefaultCodeEnum.SUCCESS_CODE.code());
        vo.setData(data);
        return vo;
    }

    /**
     * 不带有UUID的vo
     */
    @ResponseBody
    @RequestMapping(value = "/cryptvo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "cryptvo", httpMethod = "POST", notes = "不带有UUID的vo", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({@ApiImplicitParam(required = true, name = "data", value = "加密参数", paramType = "body", dataType = "DataVo")})
    public RspVo cryptvo(@RequestBody DataVo data) {
        logger.debug(" ======>>>>>>>>> /demo/cryptvo-----{}-----", data);
        RspVo vo = new RspVo();
        vo.setCode(DefaultCodeEnum.SUCCESS_CODE.code());
        vo.setData(data);
        return vo;
    }

    /**
     * 带有UUID的vo
     */
    @ResponseBody
    @ApiOperation(value = "cryptUuidvo", httpMethod = "POST", notes = "带有UUID的vo", produces = "application/json;charset=UTF-8")
    @ApiImplicitParams({@ApiImplicitParam(required = true, name = "data", value = "加密参数", paramType = "body", dataType = "UuidDataVo")})
    @RequestMapping(value="/cryptUuidvo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public RspVo cryptUuidvo(@RequestBody UuidDataVo data) {
        logger.debug(" ======>>>>>>>>> /demo/cryptUuidvo-----{}-----", JSON.toJSONString(data));
        RspVo vo = new RspVo();
        vo.setCode(DefaultCodeEnum.SUCCESS_CODE.code());
        vo.setData(data.getData());
        return vo;
    }

}
