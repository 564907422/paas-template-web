package com.paas.template.demo.controller;


import java.util.Map;

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

import com.paas.template.demo.service.ITemplatedemoService;
import com.paas.template.demo.vo.DataVo;
import com.paas.template.demo.vo.UuidDataVo;

@Controller
@RequestMapping("/demo")
public class TemplatedemoController {
	
	private static Logger logger = LoggerFactory.getLogger(TemplatedemoController.class);
	
	@Autowired
	ITemplatedemoService demoService;
	
	@ResponseBody
	@RequestMapping(value="/query",method = RequestMethod.GET)
	public RspVo query(String name) {
		logger.debug(" ======>>>>>>>>> /demo/query--{}---------",name);
		return RspVo.success(demoService.selectById(1));
	}
	
	//自动加解密
	@ResponseBody
	@RequestMapping(value="/crypt", method = RequestMethod.POST)
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
	@RequestMapping(value="/cryptvo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
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
	@RequestMapping(value="/cryptUuidvo", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public RspVo cryptUuidvo(@RequestBody UuidDataVo data) {
		logger.debug(" ======>>>>>>>>> /demo/cryptUuidvo-----{}-----", JSON.toJSONString(data));
		RspVo vo = new RspVo();
		vo.setCode(DefaultCodeEnum.SUCCESS_CODE.code());
		vo.setData(data.getData());
		return vo;
	}
	
}
