package com.example.demo;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {
	@GetMapping("/api")
	public String api(@RequestHeader Map<String, Object> header,  HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		sb.append(request.getMethod()).append(" ");
		sb.append(request.getProtocol()).append(" ");
		sb.append(request.getRequestURI()).append(System.getProperty("line.separator"));
		for (Map.Entry<String, Object> entry : header.entrySet()) {
			sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}
