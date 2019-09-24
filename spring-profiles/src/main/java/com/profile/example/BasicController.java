package com.profile.example;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class BasicController {

	@Autowired
	private BasicConfig basicConfig;


	@GetMapping()
	public Map<String,String> mytest(){

		Map<String,String> map=new HashMap<String, String>();

		map.put(basicConfig.getId(),basicConfig.getName());

		return map;
	}

}
