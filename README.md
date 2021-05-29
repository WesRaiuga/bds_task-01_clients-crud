# Clients CRUD API

[![Pt-BR Badge](https://img.shields.io/badge/README-Pt--BR-green?style=flat&color=00bd00)](README.pt-br.md)

Clients API, developed as an exercise of the [DevSuperior's](https://devsuperior.com "DevSuperior's website") **Spring React Bootcamp**.

# Technologies

- Java
- Spring
- Maven
- H2 Database

# Documentation

### Client
## ![GET](https://img.shields.io/badge/-GET-blue?color=61AFFE) /clients
Paged client search
<details>
<summary>Params</summary>

```json
- page
    type: integer
    default: 0

- linesPerPage
    type: integer
    default: 10

- direction
    type: string
    default: "ASC"

- orderBy
    type: string
    default: "name"
```

</details>

<details>
<summary>Success</summary>

```json
// REQUEST: /clients?page=0&linesPerPage=2&direction=ASC&orderBy=name
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

## ![POST](https://img.shields.io/badge/-POST-green?color=49CC90) /clients
Insert new client
<details>
<summary>Body</summary>

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
<summary>Success</summary>

```json
// REQUEST: /clients
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

## ![GET](https://img.shields.io/badge/-GET-blue?color=61AFFE) /clients/{id}
Search client by id
<details>
<summary>Params</summary>

```json
- id
    * required
    type: integer
```

</details>

<details>
<summary>Success</summary>

```json
// REQUEST: /clients/1
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
<summary>Errors</summary>

```json
// REQUEST: /clients/99
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

## ![PUT](https://img.shields.io/badge/-PUT-orange?color=FCA130) /clients/{id}
Update client
<details>
<summary>Params</summary>

```json
- id
    * required
    type: integer
```

</details>

<details>
<summary>Body</summary>

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
<summary>Success</summary>

```json
// REQUEST: /clients/1
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
<summary>Errors</summary>

```json
// REQUEST: /clients/99
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

## ![DELETE](https://img.shields.io/badge/-DELETE-red?color=F93E3E) /clients/{id}
Delete client
<details>
<summary>Params</summary>

```json
- id
    * required
    type: integer
```

</details>

<details>
<summary>Success</summary>

```json
// REQUEST: /clients/1
// STATUS: 204 NO CONTENT
```

</details>

<details>
<summary>Errors</summary>

```json
// REQUEST: /clients/99
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

# How to run the project
Requirements: Java 11

Postman collection for testing: [BDS_01_crud_clients.postman_collection.json](BDS_01_crud_clients.postman_collection.json)

```bash
# clone repository
git clone https://github.com/WesRaiuga/bds_task-01_clients-crud.git

# enter the project folder
cd bds_task-01_clients-crud

# run the project
./mvnw spring-boot:run
```

# Author

Weslley Alves de Aguiar

[![LinkedIn Badge](https://img.shields.io/badge/LinkedIn-blue?style=flat&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/wesraiuga/?locale=en_US)

# Reference and thanks

- [DevSuperior](https://devsuperior.com "Site da DevSuperior")
- [Professor Nelio Alves](https://www.youtube.com/c/DevSuperior/featured "Canal no youtube da DevSuperior")