# -CaseTheCatAPI-

As informações desse projeto para a construção e implementação das APIs estão sendo coletadas em: https://thecatapi.com/

Projeto realizado na linguagem: Java

IDE utilizada: Eclipse

Framework: Spring Boot

Para rodar essa aplicação basta clonar esse repositório e importar na IDE de sua preferência.

_____________________________________


Desenho Arquitetural Informando como a solução irá funcionar: 

![image](https://user-images.githubusercontent.com/86810509/169527164-9c9dca0d-a5ba-48d1-954e-2c699f30776d.png)
 
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

Para cada teste, foi criado a sua classe "TheCatCategories" e "TheCatImages" passando os parâmetros de cada url. Vale ressaltar que existe uma biblioteca chamada lombok que é focada em produtividade e redução do código boilerplate, digo isso porque ele evita a escrita dos métodos getters e setters, além de equals, builder, etc. O intuito é ir implementando essas melhorias conforme formos caminhando na codificação, entretanto, caso você queira implementar no seu código, basta adicionar a seguinte dependência no seu pom.xml:

	<dependency>
	    <groupId>org.projectlombok</groupId>
	    <artifactId>lombok</artifactId>
	    <version>1.16.20</version>
	    <scope>provided</scope>
	</dependency>
	
É preciso instalar um plugin do lombok para que as IDEs consigam enxergar quais serão os métodos criados pelas anotações do Lombok e nos dar acesso a eles.

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

_____________________________________________________________________________________

Melhorias no código: 

Quando pensamos em um código limpo é importante evitar que algumas informações sejam repetitivas, diante disso, implementei melhorias na classe "ApiApplicationController.java", a primeira delas foi tirar a repetição do código e alguns testes que foram feitos e mostrados e documentados acima. 

Implementei também logo acima da classe o @RequestMapping(/cat-api/) além de agora conseguimos buscar as raças de gatos a partir de um ID específico: 

	@RequestMapping(value = "/{breed_id}")
		public Object[] getBreed(@PathVariable(value = "breed_id") String breedId) {
			String url = "https://api.thecatapi.com/v1/images/search?breed_id=" + breedId;
			ResponseEntity<Object[]> response = new RestTemplate().getForEntity(url, Object[].class);
	
			return response.getBody();
		}  
	
![image](https://user-images.githubusercontent.com/86810509/169547293-aaba441c-38df-4511-ac67-cf376c758bbb.png)

Imagem acima mostrando como ficou nossa nova coleção no postman onde precisamos passar a requisição http://localhost:8082/cat-api/ + a raça específica que queremos listar.

___________________________________________________________________________________________________________________________________

Outra etapa de extrema importância é a documentação da nossa API, existem várias ferramentas que ajudam a criar uma boa documentação, as principais são API Blueprint, RAML e Swagger. Nessa projeto, irei utilizar o Swagger. Antes de mais nada, o Swagger é um framework composto por diversas ferramentas que, independente da linguagem, auxilia a descrição, consumo e visualização de serviços de uma API REST. 

Para esse projeto em específico eu escolhi o Swagger Editor, que é uma ferramenta online que permite criar manualmente a documentação da API. Um dos benefícios de usar a YAML, é que o editor possui um conjunto de templates que servem como base para quem não deseja iniciar a documentação do “zero".

![image](https://user-images.githubusercontent.com/86810509/169547629-3fbf2b55-6b1d-4409-a514-87b1d0eb213e.png)

_____________________________________________________________________________________________________________________________________


Seguindo mais adiante, a ideia é começar a armazenar as informações em uma base de dados. A tentativa aqui é voltar a usar o Docker, depois de algum tempo sem trabalhar diretamente com banco de dados nas aplicações, comecei pela instalação na minha máquina pessoal, onde lá você pode encontrar a opção ideal para sua máquina (mac, windows ou linux). 

É importante se atentar que se sua máquina for *Windows 10* assim como a minha você precisará abrir o Windows PowerShell como Administrador e realizador os seguintes comandos antes:

WSL2 e Docker no Windows 10

Passo 1: 

dism.exe /online /enable-feature /featurename:Microsoft-Windows-Subsystem-Linux /all /norestart

Passo 2:

dism.exe /online /enable-feature /featurename:VirtualMachinePlatform /all /norestart

Passo 3 - REINICIE O COMPUTADOR

Passo 4 (Download the Linux kernel update package):

https://wslstorestorage.blob.core.windows.net/wslblob/wsl_update_x64.msi

Passo 5:

wsl --set-default-version 2

Passo 7:

Tutorial: https://docs.docker.com/docker-for-windows/install/

________________________________________________________________________________

Com o docker instalado, é importante entendermos os primeiros e principais comandos que usamos no prompt de comando, listei alguns abaixo:

docker run : Cria um container como uma imagem

docker ps : Exibe os containers que estão em execução 

docker ps –a : Exibe todos os containers, inclusive os que não estão mais em execução.

docker start : Inicializa um container, basta passar as inicias do seu ID.

docker stop : Esse comando para o container, basta passar as iniciais do seu ID. 

