package com.alibaba.dubbo.rpc.filter;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;

@Activate(group = Constants.CONSUMER)
public class ConsumerFilter implements Filter {
	
	private static final Logger log = LoggerFactory.getLogger(ConsumerFilter.class);
	
	private static final String trace_key="trace_id";
	
    int num=0;
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

		RpcContext curContext = RpcContext.getContext();
		curContext.get().putIfAbsent(trace_key, UUID.randomUUID().toString().replace("-", ""));
		log.info("0.---->>>在隐式传参中查找参数--->>test={}",curContext.getAttachment(trace_key));
		curContext.setAttachment(trace_key,   String.valueOf(curContext.get(trace_key)));
		log.info("1.---->>>在上下文中查找参数--->>test={}",curContext.get(trace_key));
		log.info("2.---->>>在隐式传参中查找参数--->>test={}",curContext.getAttachment(trace_key));
    	try {
    		return invoker.invoke(invocation);
		} finally { 
			log.info("3.---->>>在上下文中查找参数--->>test={}",curContext.get(trace_key));
			log.info("4.---->>>在隐式传参中查找参数--->>test={}",curContext.getAttachment(trace_key));
		}
    }

}