package com.cat.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cat-api/")
public class ApiApplicationController {

	// api-categories - Acessando a API Categories e obtendo ID e NAME 

	@GetMapping(value = "/categories")
	public Object[] getCategories() {
		String url = "https://api.thecatapi.com/v1/categories";
		ResponseEntity<Object[]> response = new RestTemplate().getForEntity(url, Object[].class);

		return response.getBody();
	}

	// api-images - Acessando a API Images

	@GetMapping(value = "/images")
	public Object[] getImagens() {
		String url = "https://api.thecatapi.com/v1/images/search";
		ResponseEntity<Object[]> response = new RestTemplate().getForEntity(url, Object[].class);

		return response.getBody();
	}
	
	//api-breeds - a) API capaz de listar todas as raças

	@GetMapping(value = "/breeds")
	public Object[] getBreeds() {
		String url = "https://api.thecatapi.com/v1/breeds";
		ResponseEntity<Object[]> response = new RestTemplate().getForEntity(url, Object[].class);

		return response.getBody();
	}
	
	// api-breeds - b) API capaz de listar as informações de uma raça a partir de um ID

	@RequestMapping(value = "/{breed_id}")
	public Object[] getBreed(@PathVariable(value = "breed_id") String breedId) {
		String url = "https://api.thecatapi.com/v1/images/search?breed_id=" + breedId;
		ResponseEntity<Object[]> response = new RestTemplate().getForEntity(url, Object[].class);

		return response.getBody();
	}
}
