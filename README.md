# Micro Serviço de Gerenciamento de Cliente

O objetivo do MS Clientes é fornecer uma aplicação para fazer o gerenciamento de clintes de todas as nossas aplicações.
Ele oferece um serviço de cadastro, exclusão e busca de clientes através de REST APIs.



## Configurações 

- Java 17
- Maven
- Spring Boot
- Mongo DB

## Setup

Para rodar o projeto basta fazer o clone do projeto e configurar a conexão ao banco de dados. 
É importante destacar que o projeto foi feito usando como base o Mongo DB.

## Requisições

As requisições do projeto são bem simples:

Para adicionar um usuário basta fazer as seguintes requisições: 
Criar Usuário POST - http://localhost:8080/user
    ``{
	    "cpf": "123",
	    "nome": "João",
	    "email": "joao@joao",
	    "documento": "123456",
	    "endereco": {
	    "rua": "lala",
	    "bairo": "lalala",
	    "numero": "123",
	    "cep": "lalala",
	    "cidade": "lalala",
	    "complemento": "lalalala"
	    }
    ``}
   Buscar usuário GET - http://localhost:8080/user?email=joao@joao
   Buscar usuário DELETE - http://localhost:8080/user?email=joao@joao
