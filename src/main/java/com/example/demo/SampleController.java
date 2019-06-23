package com.example.demo;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	
	@PostMapping("/login")
	@ResponseBody
	public Login login(@RequestParam String id, @RequestParam String name) {
		Login login = new Login();
		login.setId(id);
		login.setName(name);
		return  login;
	}
	
	@GetMapping("/login/{id}")
	@ResponseBody
	public Login login(@PathVariable String id) {
		Login login = new Login();
		login.setId(id);
		return  login;
	}
	
	@PostMapping("/login2")
	@ResponseBody
	public Login login2(@RequestParam Map<String, String> params) {
		Login login = new Login();
		login.setId(params.get("id"));
		login.setId(params.get("name"));
		return  login;
	}
	
	
	@PostMapping("/bindingTest")
	@ResponseBody
	public Login binding(@Valid @ModelAttribute Login login, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("에러가 있다 : ");
			bindingResult.getAllErrors().forEach(result ->{
				//throw new MyError(400, "값이 정상이 아님");
				System.out.println("결과 : "+result.toString());
			});
		}
		return login;
	}
	
}
