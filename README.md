# 🛒 ShopBackend - Spring Boot E-commerce API

Backend e-commerce développé avec **Spring Boot 3**, **Spring Security**, **JWT Authentication** et **MySQL**.

Ce projet permet :

* Authentification sécurisée avec JWT
* Gestion des rôles USER / ADMIN
* CRUD complet des produits
* Gestion des commandes
* Recherche de produits
* API REST sécurisée

---

#  Technologies utilisées

* Java 17
* Spring Boot 3
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA
* MySQL
* Maven
* Lombok

---

#  Structure du projet

```bash
src/main/java/com/example/shopbackend

├── config
├── controller
├── dto
├── entity
├── enums
├── repository
├── security
├── service
└── ShopBackendApplication.java
```

---

#  Fonctionnalités

## Authentification

* Inscription utilisateur
* Connexion utilisateur
* JWT Token

## Gestion des rôles

* USER
* ADMIN

## Produits

* Ajouter produit (ADMIN)
* Modifier produit (ADMIN)
* Supprimer produit (ADMIN)
* Liste paginée des produits
* Recherche produits

## Commandes

* Créer commande
* Voir ses commandes

---

#  Installation

## 1. Cloner le projet

```bash
git clone https://github.com/Fayabd25/Projet_java.git
```

---

## 2. Ouvrir dans IntelliJ IDEA

---

## 3. Créer la base MySQL

```sql
CREATE DATABASE shopdb;
```

---

## 4. Configurer application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/shopdb
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

jwt.secret=mysupersecretkeymysupersecretkey
```

---

## 5. Lancer l'application

Exécuter :

```bash
ShopBackendApplication.java
```

---

#  Authentification JWT

Après connexion :

```json
{
  "token": "eyJhbGciOi..."
}
```

Utiliser dans Postman :

```text
Authorization: Bearer TOKEN
```

---

#  Endpoints API

##  Public

### Register

```http
POST /api/auth/register
```

### Login

```http
POST /api/auth/login
```

### Liste produits

```http
GET /api/products
```

---

##  USER

### Créer commande

```http
POST /api/orders
```

### Mes commandes

```http
GET /api/orders/my-orders
```

---

##  ADMIN

### Ajouter produit

```http
POST /api/admin/products
```

### Modifier produit

```http
PUT /api/admin/products/{id}
```

### Supprimer produit

```http
DELETE /api/admin/products/{id}
```

### Liste utilisateurs

```http
GET /api/admin/users
```

---

#  Exemple Register

```json
{
  "username":"test",
  "email":"test@gmail.com",
  "password":"123456"
}
```

---

#  Exemple Login

```json
{
  "email":"test@gmail.com",
  "password":"123456"
}
```

---

#  Exemple Produit

```json
{
  "name":"iPhone 15",
  "description":"Apple smartphone",
  "price":1200,
  "stockQuantity":10,
  "lienImage":"https://image.com/iphone.jpg"
}
```

---

#  Auteur

Projet réalisé par Fayabd25.

---


