package com.cat.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiApplicationController {
	
	//api-categories
	
	@RequestMapping("/api-categories")
	public String api(){
		return "Api de Categorias";
	}
	
	@GetMapping(value = "/cat")
	public String getApiCat(){
		String uri = "http://localhost:8082/api-categories";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
	
	@GetMapping(value = "/categories")
	public Object[] getCategories(){
		String url = "https://api.thecatapi.com/v1/categories";
		ResponseEntity<Object[]> response = new RestTemplate().getForEntity(url, Object[].class);
		
		return response.getBody();	
	}
	
	//api-images
	
	@RequestMapping("/api-images")
	public String api2(){
		return "Api de Imagens";
	}
	
	@GetMapping(value = "/img")
	public String getApiImg(){
		String uri = "http://localhost:8082/api-images";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}
	
	@GetMapping(value = "/images")
	public Object[] getImagens(){
		String url = "https://api.thecatapi.com/v1/images/search";
		ResponseEntity<Object[]> response = new RestTemplate().getForEntity(url, Object[].class);
		
		return response.getBody();	
	}
}
