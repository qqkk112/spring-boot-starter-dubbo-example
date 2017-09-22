package com.alibaba.dubbo.rpc.filter;

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

@Activate(group = Constants.PROVIDER)
public class ProviderFilter implements Filter {
	
	private static final Logger log = LoggerFactory.getLogger(ProviderFilter.class);

	
	private static final String trace_key="trace_id";
	
    int num=0;
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

		RpcContext curContext = RpcContext.getContext();
		log.info("0.---->>>在上下文中查找资源--->>trace={}",curContext.get(trace_key));
		log.info("1.---->>>在隐式传参中查找参数--->>trace={}",curContext.getAttachment(trace_key));
		try {
			return invoker.invoke(invocation);
		} finally {
			log.info("2.---->>>在上下文中查找资源--->>trace={}",curContext.get(trace_key));
			log.info("3.---->>>在隐式传参中查找参数--->>trace={}",curContext.getAttachment(trace_key));
		}
    }

}