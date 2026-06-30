package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@GetMapping("/product")
public String getproduct() throws Exception {
		Thread.sleep(5000);
	return"laptop Price = Rupess-65000";
}
}
