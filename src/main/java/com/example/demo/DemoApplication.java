package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@SpringBootApplication
@RestController(value = "/yas/")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/test")
	public String test(HttpServletRequest request) {
		System.out.println(request.getMethod());
		System.out.println(request.getServerPort());
		System.out.println(request.getRequestId());  // Le id de la requete, incremental
		System.out.println(request.getRemoteHost());
		System.out.println(request.getServletPath());   // endPoint
		System.out.println(request.getRemoteUser());

		return request.getRemoteAddr();
	}

	@GetMapping("/te")
	public void test2(@RequestParam("param1") String s, @RequestParam("param2") String s12, HttpServletRequest request) {
		//System.out.println(request.getPathInfo());
		//String[] parameterValues = request.getParameterValues();
		/*String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println(requestURI);
		System.out.println(requestURL.toString());*/
		Enumeration<String> parameterNames = request.getParameterNames();
		StringBuilder requestParameters = new StringBuilder();
		requestParameters.append("{");
		while(parameterNames.hasMoreElements()) {
			String parameter = parameterNames.nextElement();
			String[] parameterValues = request.getParameterValues(parameter);
			StringBuilder value = new StringBuilder();
			for (String v:parameterValues) {
				value.append(v);
			}
			requestParameters.append(parameter + " : " + value + ", ");
		}
		requestParameters.append("}");
		System.out.println(requestParameters.toString());

	}

	@GetMapping(value = "/custom-params")
	public String customParams(@RequestParam("param1") String s, @RequestParam("param2") String s12) throws Exception {
		if(s.equals("yassin"))
			throw new Exception("Exception on my part");
		return "OK";
	}



}
