# 🚀 Tienda API - Backend Service

Este es un servicio RESTful robusto construido con **Java 21** y **Spring Boot 3**. Diseñado bajo una arquitectura de capas (Controller-Service-Repository) para garantizar un código modular, mantenible y escalable.

## 🛠 Tecnologías Utilizadas

* **Java 21**
* **Spring Boot 3.x**
* **Spring Data JPA** (Persistencia)
* **PostgreSQL** (Base de datos relacional)
* **Maven** (Gestión de dependencias)
* **Docker** (Contenedor de infraestructura)

## 📊 Modelo de Datos

```mermaid
erDiagram
    CLIENTES ||--o{ PRODUCTOS : ""
    CLIENTES {
        long id PK
        string nombre
        string apellido
        string correo
        string telefono
        string direccion
    }
    PRODUCTOS {
        long id PK
        string nombre
        string descripcion
        double precio
        int stock
        string categoria
    }
