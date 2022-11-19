package com.authentication.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {
	Logger logger = LoggerFactory.getLogger(AspectConfig.class);
	@Autowired
	   HttpServletRequest request;
	
	@Before("execution(* com.authentication.controller.MainController.loginUser(..)))")
	public  void userAuthenticate() {
		logger.info("user logged in. "+ request.getHeader("username"));
	}
}
