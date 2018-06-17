package com.reger.test.provider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.reger.test.exception.TestRuntimeException;
import com.test.dubbo.model.User;
import com.test.dubbo.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Service(protocol="dubbo-jvm",registry="test")
public class MathServiceImpl implements MathService {

//	@Autowired
//	private UserService userService;

	@Override
	public Integer add( Integer a, Integer b) {
		System.err.println("请求到达  " + a + "+" + b + "=" + (a + b));
		return a + b;
	}

	@Override
	public List<Object> toList(Object... args) {
		List<Object> list = new ArrayList<Object>();
		Collections.addAll(list, args);
		System.err.println("返回的数据"+list);
		return list;
	}
	@Override
	public void throwThrowable() {
		throw new TestRuntimeException("专门抛出一个异常试试异常时！");
	}

	@Override
	public User getUser(User user) {
		System.err.println("请求到达  " +user);
		return user;
	}

	@Override
	public String getList() {
		return "";
		//return JSON.toJSONString(userService.selectAll());
	}
}
