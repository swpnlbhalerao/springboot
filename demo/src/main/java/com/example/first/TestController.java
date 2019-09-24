package com.example.first;



import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class TestController {

@Autowired
private CredentialsService c;



//	@RequestMapping("/")
//	public String  test() throws URISyntaxException{
//		System.out.println("hi");
//		c.accessCredentials();
//		return "null";
//	}
	/*
	 * @RequestMapping("/add") public String addPerson(Person person){
	 * personRepo.save(person); return "test.jsp"; }
	 */

	@GetMapping("/hello")
	@ResponseBody
	public Object hello() {
		System.out.println("Hello");
		Credentials cred=new Credentials();
		cred.setExcited("yes");
		cred.setName("Swapnil");
		return cred;
	}
	

	@PostMapping("/hi")
	@ResponseBody
	public Object hi(@RequestBody String body) {
		return body;
	}
	

	
	
	
}
