# API CRUD de Clientes

[![En-US Badge](https://img.shields.io/badge/README-En--US-red?style=flat&logoColor=white)](README.md)

API de clientes, desenvolvida como exercício do curso **Bootcamp Spring React** da [DevSuperior](https://devsuperior.com "Site da DevSuperior") edição 3.0.

# Tecnologias

- Java
- Spring
- Maven
- H2 Database

# Documentação

### Cliente
## ![GET](https://img.shields.io/badge/-GET-blue?color=61AFFE) /clients
Busca paginada de clientes
<details>
<summary>Parâmetros</summary>

```json
- page
    tipo: integer
    padrão: 0

- linesPerPage
    tipo: integer
    padrão: 10

- direction
    tipo: string
    padrão: "ASC"

- orderBy
    tipo: string
    padrão: "name"
```

</details>

<details>
<summary>Sucesso</summary>

```json
// REQUISIÇÃO: /clients?page=0&linesPerPage=2&direction=ASC&orderBy=name
// STATUS: 200 OK
{
    "content": [
        {
            "id": 9,
            "name": "Allana Hadassa Daiane Silva",
            "cpf": "51823344607",
            "income": 1060.0,
            "birthDate": "1990-11-23T08:38:00.123450Z",
            "children": 1
        },
        {
            "id": 10,
            "name": "Antonella Ester Mariane Galvão",
            "cpf": "47339915680",
            "income": 9870.0,
            "birthDate": "1983-02-15T02:40:00.123450Z",
            "children": 2
        }
    ],
    "pageable": {
        "sort": {
            "sorted": true,
            "unsorted": false,
            "empty": false
        },
        "pageNumber": 0,
        "pageSize": 2,
        "offset": 0,
        "unpaged": false,
        "paged": true
    },
    "last": false,
    "totalPages": 10,
    "totalElements": 20,
    "sort": {
        "sorted": true,
        "unsorted": false,
        "empty": false
    },
    "first": true,
    "numberOfElements": 2,
    "size": 2,
    "number": 0,
    "empty": false
}
```

</details>
<br/>


## ![POST](https://img.shields.io/badge/-POST-green?color=49CC90) /clients
Inserção de novo cliente
<details>
<summary>Corpo</summary>

```json
{
    "name": "Maria Silva",
    "cpf": "12345678901",
    "income": 6500.0,
    "birthDate": "1994-07-20T10:30:00Z",
    "children": 2
}
```

</details>

<details>
<summary>Sucesso</summary>

```json
// REQUISIÇÃO: /clients
// STATUS: 201 CREATED
{
    "id": 21,
    "name": "Maria Silva",
    "cpf": "12345678901",
    "income": 6500.0,
    "birthDate": "1994-07-20T10:30:00Z",
    "children": 2
}
```

</details>
<br/>

## ![GET](https://img.shields.io/badge/-GET-blue?color=61AFFE) /clients/{id}
Busca de cliente por id
<details>
<summary>Parâmetros</summary>

```json
- id
    * obrigatório
    tipo: integer
```

</details>

<details>
<summary>Sucesso</summary>

```json
// REQUISIÇÃO: /clients/1
// STATUS: 200 OK
{
    "id": 1,
    "name": "Catarina Sara da Silva",
    "cpf": "18183307094",
    "income": 1990.0,
    "birthDate": "1956-12-15T22:01:00.123450Z",
    "children": 0
}
```

</details>

<details>
<summary>Erros</summary>

```json
// REQUISIÇÃO: /clients/99
// STATUS: 404 NOT FOUND
{
    "timestamp": "2021-05-29T21:20:55.164289400Z",
    "status": 404,
    "error": "Resource not found",
    "message": "Client not found (id: 99)",
    "path": "/clients/99"
}
```

</details>
<br/>

## ![PUT](https://img.shields.io/badge/-PUT-orange?color=FCA130) /clients/{id}
Atualização de cliente
<details>
<summary>Parâmetros</summary>

```json
- id
    * obrigatório
    tipo: integer
```

</details>

<details>
<summary>Corpo</summary>

```json
{
    "name": "Maria Silvaaa",
    "cpf": "24835675961",
    "income": 7500.0,
    "birthDate": "1994-07-20T10:30:00Z",
    "children": 2
}
```

</details>

<details>
<summary>Sucesso</summary>

```json
// REQUISIÇÃO: /clients/1
// STATUS: 200 OK
{
    "id": 1,
    "name": "Maria Silvaaa",
    "cpf": "24835675961",
    "income": 7500.0,
    "birthDate": "1994-07-20T10:30:00Z",
    "children": 2
}
```

</details>

<details>
<summary>Erros</summary>

```json
// REQUISIÇÃO: /clients/99
// STATUS: 404 NOT FOUND
{
    "timestamp": "2021-05-29T21:20:55.164289400Z",
    "status": 404,
    "error": "Resource not found",
    "message": "Client not found (id: 99)",
    "path": "/clients/99"
}
```

</details>
<br/>

## ![DELETE](https://img.shields.io/badge/-DELETE-red?color=F93E3E) /clients/{id}
Exclusão de cliente
<details>
<summary>Parâmetros</summary>

```json
- id
    * obrigatório
    tipo: integer
```

</details>

<details>
<summary>Sucesso</summary>

```json
// REQUISIÇÃO: /clients/1
// STATUS: 204 NO CONTENT
```

</details>

<details>
<summary>Erros</summary>

```json
// REQUISIÇÃO: /clients/99
// STATUS: 404 NOT FOUND
{
    "timestamp": "2021-05-29T21:20:55.164289400Z",
    "status": 404,
    "error": "Resource not found",
    "message": "Client not found (id: 99)",
    "path": "/clients/99"
}
```

</details>
<br/>

# Como executar o projeto
Pré-requisitos: Java 11

Coleção do Postman para testes: [BDS_01_crud_clients.postman_collection.json](BDS_01_crud_clients.postman_collection.json)

```bash
# clonar repositório
git clone https://github.com/WesRaiuga/bds_task-01_clients-crud.git

# entrar na pasta do projeto
cd bds_task-01_clients-crud

# executar o projeto
./mvnw spring-boot:run
```

# Autor

Weslley Alves de Aguiar

[![LinkedIn Badge](https://img.shields.io/badge/LinkedIn-blue?style=flat&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/wesraiuga/?locale=pt_BR)

# Referência e agradecimentos

- [DevSuperior](https://devsuperior.com "Site da DevSuperior")
- [Professor Nelio Alves](https://www.youtube.com/c/DevSuperior/featured "Canal no youtube da DevSuperior")