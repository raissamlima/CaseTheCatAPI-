package com.cat.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cat.api.TheCatCategories;
import com.cat.api.TheCatImages;

@RestController
public class ApiApplicationController {

	// api-categories - Acessando a API Categories e obtendo ID e NAME 

	@RequestMapping("/api-categories")
	public String api() {
		return "Api de Categorias";
	}

	@GetMapping(value = "/cat")
	public String getApiCat() {
		String uri = "http://localhost:8082/api-categories";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}

	@GetMapping(value = "/categories")
	public Object[] getCategories() {
		String url = "https://api.thecatapi.com/v1/categories";
		ResponseEntity<Object[]> response = new RestTemplate().getForEntity(url, Object[].class);

		return response.getBody();
	}

	// api-images - Acessando a API Images

	@RequestMapping("/api-images")
	public String api2() {
		return "Api de Imagens";
	}

	@GetMapping(value = "/img")
	public String getApiImg() {
		String uri = "http://localhost:8082/api-images";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}

	@GetMapping(value = "/images")
	public Object[] getImagens() {
		String url = "https://api.thecatapi.com/v1/images/search";
		ResponseEntity<Object[]> response = new RestTemplate().getForEntity(url, Object[].class);

		return response.getBody();
	}
	
	//api-breeds - a) API capaz de listar todas as raças
	
	@RequestMapping("/api-breeds01")
	public String api3() {
		return "Api de Breeds - Todas as Raças";
	}

	@GetMapping(value = "/breeds_selection")
	public String getApiBreeds() {
		String uri = "http://localhost:8082/api-breeds";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}

	@GetMapping(value = "/breeds")
	public Object[] getBreeds() {
		String url = "https://api.thecatapi.com/v1/breeds";
		ResponseEntity<Object[]> response = new RestTemplate().getForEntity(url, Object[].class);

		return response.getBody();
	}
	
	// api-breeds - b) API capaz de listar as informações de uma raça

	@RequestMapping("/api-breeds02")
	public String api4() {
		return "Api de Breeds - Gato de Bengala";
	}

	@GetMapping(value = "/bengal_selection")
	public String getApiBengal() {
		String uri = "http://localhost:8082/api-breeds";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		return result;
	}

	@GetMapping(value = "/bengal")
	public Object[] getBengal() {
		String url = "https://api.thecatapi.com/v1/images/search?breed_id=beng";
		ResponseEntity<Object[]> response = new RestTemplate().getForEntity(url, Object[].class);

		return response.getBody();
	}

	// thecatcategories

	@RequestMapping("/thecatcategories")
	public List<TheCatCategories> listacategories() {
		TheCatCategories categories = new TheCatCategories(5, "boxes");

		return Arrays.asList(categories);
	}

	// thecatimages

	@RequestMapping("/thecatimages")
	public List<TheCatImages> listaimages() {
		TheCatImages images = new TheCatImages("[]", "gkO9UupeT", "https://cdn2.thecatapi.com/images/gkO9UupeT.jpg", 3329, 2219);

		return Arrays.asList(images);
	}
}
