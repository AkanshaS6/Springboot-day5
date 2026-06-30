package com.example.demo.consumer;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartRestConsumer {
	private final DiscoveryClient discoveryClient;

	CartRestConsumer(DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
	}
	public String getCartData() {
		List<ServiceInstance> instances = discoveryClient.getInstances("CART-SERVICE");
		if(instances==null || instances.isEmpty()) {
			return "CART-SERVICE NOT available right now";
		}
		//Pick first available instance
	ServiceInstance	instance = instances.get(0);
	//create url to call cart-service
	String url= instance.getUri() + "/cart/getData";
	RestTemplate restTemplate = new RestTemplate();
	return restTemplate.getForObject(url,String.class);
	}
}
