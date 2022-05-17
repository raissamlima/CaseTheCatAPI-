# CaseTheCatAPI-

Etapa 1: Criação do projeto Spring Boot

Visite o site: https://start.spring.io/ e crie um projeto Java, lá você pode escolher a sua versão e adicionar suas dependências, a princípio adicionei a dependência "Spring Web" (você poderá ver essas dependências no arquivo pom.xml)

![image](https://user-images.githubusercontent.com/86810509/168702835-19d389c7-68ee-4e97-ada0-f29824290db0.png)

Após descompactar o projeto criado no inicializador do Spring Boot, criei a pasta "com.cat.api.controller" e a classe "ApiApplicationController.java" onde foi mapeado as requests das APIS de "Categories" e "Images". 
A solicitação foi feita por meio GET (que faz a leitura de dados no host), usei o Postman que é um aplicativo com a função de testar e desenvolver APIs em uma interface bastante simples. Ele me permitiu simular a requisição HTTP de forma rápida, onde foi retornado o status 200, que significa o sucesso da requisição.

No postman então foi criado uma biblioteca "CaseTheCatApi" com todas as requisições feitas e o body retornado. 

Criei para testar a classe "ApiApplicationTests" com o seguinte código:
	
	@Test
	public void consumerAPICategories() {
			
		ResponseEntity<TheCatCategories[]> entity = new RestTemplate().getForEntity("https://api.thecatapi.com/v1/categories", TheCatCategories[].class);
		
		for (TheCatCategories cat: entity.getBody()){
			System.out.println(cat.getName());
		}	
	}
	
	@Test
	public void consumerAPIImagens() {
			
		ResponseEntity<TheCatImages[]> entity = new RestTemplate().getForEntity("https://api.thecatapi.com/v1/images/search", TheCatImages[].class);
		
		for (TheCatImages cat: entity.getBody()){
			System.out.println(cat.getUrl());
		}	
	}


Em "consumerAPICategories" é retornado a lista de todos os nomes dos gatos disponíveis na url https://api.thecatapi.com/v1/categories;

No segundo teste "consumerAPIImagens" é retornado a url da imagem encontrada em https://api.thecatapi.com/v1/images/search;

Para cada teste, foi criado a sua classe "TheCatCategories" e "TheCatImages" passando os parâmetros de cada url. 
