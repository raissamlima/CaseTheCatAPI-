# CaseTheCatAPI-

Desenho Arquitetural Informando como a solução irá funcionar: 

![image](https://user-images.githubusercontent.com/86810509/168922464-cc201262-7ef8-4dfb-8e5d-d3418e5999a9.png)

Observação: Esse desenho é referente a construção das 4 APIs REST. 

Etapa 1: Criação do projeto Spring Boot

Visite o site: https://start.spring.io/ e crie um projeto Java, lá você pode escolher a sua versão e adicionar suas dependências, a princípio adicionei a dependência "Spring Web" (você poderá ver essas dependências no arquivo pom.xml)

![image](https://user-images.githubusercontent.com/86810509/168702835-19d389c7-68ee-4e97-ada0-f29824290db0.png)

Após descompactar o projeto criado no inicializador do Spring Boot importei o arquivo para a IDE de minha preferência (eclipse), criei a pasta "com.cat.api.controller" e a classe "ApiApplicationController.java" onde foi mapeado as requests das APIS de "Categories" e "Images". 
A solicitação foi feita por meio GET (que faz a leitura de dados no host), usei o Postman que é um aplicativo com a função de testar e desenvolver APIs em uma interface bastante simples. Ele me permitiu simular a requisição HTTP de forma rápida, onde foi retornado o status 200, que significa o sucesso da requisição.

No postman então foi criado uma biblioteca "CaseTheCatApi" com todas as requisições feitas e o body retornado. 

![image](https://user-images.githubusercontent.com/86810509/168703488-87256fe0-1312-41a9-9c58-1cf3cb00c9b9.png)

![image](https://user-images.githubusercontent.com/86810509/168703724-71862764-aa72-4020-bd05-bf07ee60516e.png)



Criei para testar a classe "ApiApplicationTests" com o seguinte código:
	
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


Em "consumerAPICategories" é retornado a lista de todos os nomes dos gatos disponíveis na url: https://api.thecatapi.com/v1/categories

No segundo teste "consumerAPIImagens" é retornado a url da imagem encontrada em: https://api.thecatapi.com/v1/images/search

Para cada teste, foi criado a sua classe "TheCatCategories" e "TheCatImages" passando os parâmetros de cada url. 

Observação: Outra melhoria importante de se falar foi a implementação da dependência DevTools no pom.xml, com ela não preciso mais reiniciar o servidor a cada modificação feita no código, na hora que for salva qualquer alteração o Spring já reinicia sozinho. Outro detalhe é que o escopo dessa dependência será runtime, ou seja, ele só vai rodar durante a execução do projeto. 

![image](https://user-images.githubusercontent.com/86810509/168868777-5e1e27a0-c197-4188-95e8-b0c2fddccb37.png)

Agora que os devidos testes foram feitos e que já estamos conseguindo acessar a API "TheCatApi", realizei a primeira etapa onde a API é capaz de listar todas as raças:

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
	
No postman realizei a requisição GET onde foi retornado toda a lista de raças (3117 linhas de JSON) e o status ok.

![image](https://user-images.githubusercontent.com/86810509/168923557-1d531b0a-75a1-4b21-873d-bafcfa1615fc.png)

Em seguida, realizei a segunda etapa de listar as informações de uma raça, a raça escolhida foi a do gato de bengala, podemos analisar pelo trecho abaixo:

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
	
No postman realizei a requisição GET onde foi retornado todas as informações do gato de bengala: 

![image](https://user-images.githubusercontent.com/86810509/168924341-05c3fe02-d370-435e-a8e6-33f4e4cb3ea4.png)


