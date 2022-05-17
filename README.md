# CaseTheCatAPI-

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
	public void consumerAPIImagens() {
			
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

