package com.cat.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {
	
	@Test
	public void consumerAPICategories() {
			
		ResponseEntity<TheCatCategories[]> entity = new RestTemplate().getForEntity("https://api.thecatapi.com/v1/categories", TheCatCategories[].class);
		
		for (TheCatCategories cat: entity.getBody()){
			System.out.println(cat.getName());
		}	
	}
	
	@Test
	public void consumerAPIImages() {
			
		ResponseEntity<TheCatImages[]> entity = new RestTemplate().getForEntity("https://api.thecatapi.com/v1/images/search", TheCatImages[].class);
		
		for (TheCatImages cat: entity.getBody()){
			System.out.println(cat.getUrl());
		}	
	}
}

