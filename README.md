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
```

## 🏗 Arquitectura
El proyecto sigue el **Patrón de Capas**, asegurando la separación de responsabilidades:



* **Controller:** Exposición de endpoints REST y validación de entrada.
* **Service:** Lógica de negocio y orquestación.
* **Repository:** Comunicación directa con PostgreSQL usando JPA.
* **Mapper:** Conversión segura entre Entidades y DTOs.

## 🚀 Instalación y Ejecución

### Requisitos previos
* **JDK 21** instalado.
* **Docker Desktop** ejecutándose.

### Pasos para iniciar
1. **Clonar el repositorio:**
   ```bash
   git clone <URL_DE_TU_REPOSITORIO>
   cd tienda-api
   ```
2. **Levantar PostgreSQL:**
   ```bash
   docker-compose up -d
   ```
3. **Ejecutar la API:**
   ```bash
   ./mvnw spring-boot:run
   ```

### 3. Endpoints Principales
Para esto, **una tabla es la mejor opción**. Es mucho más legible que una lista simple.

```markdown
## 🔌 Endpoints Principales

| Método | Endpoint | Descripción |
| --- | --- | --- |
| `POST` | `/clientes` | Crear cliente |
| `GET` | `/clientes` | Listar clientes |
| `GET` | `/clientes/{id}` | Buscar cliente por ID |
| `DELETE` | `/productos/{id}` | Eliminar producto |

```

## 🔄 Flujo de Datos (Arquitectura)

Para entender cómo viaja la información en nuestro proyecto, este es el camino que recorre cada petición:

1. **Controller**: Es la puerta de entrada. Recibe la petición HTTP del usuario, delega el trabajo al `Service` y devuelve la respuesta final.
2. **DTO (Data Transfer Object)**: Son objetos simples utilizados para transportar datos entre las capas. Evitan que las entidades de la base de datos se expongan directamente al exterior.
3. **Mapper**: Es el traductor. Convierte el `DTO` (que entiende el usuario) a `Entidad` (que entiende la base de datos) y viceversa.
4. **Service**: Es el cerebro de la aplicación. Aquí reside toda la lógica de negocio, validaciones y reglas de cálculo antes de tocar los datos.
5. **Repository**: Es el especialista en persistencia. Se comunica directamente con la base de datos (PostgreSQL) para guardar, buscar o eliminar información.

---

### Representación del Flujo

```mermaid
graph TD
    A[Controller] -->|Recibe/Envía| B(DTO)
    B -->|Transforma| C(Mapper)
    C -->|Convierte| D[Service]
    D -->|Gestiona Lógica| E[Repository]
    E -->|Consulta| F[(Base de Datos)]

```
