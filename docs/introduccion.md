# Introducción al Proyecto Spring Boot

Este proyecto ha sido diseñado como una guía práctica para estudiantes que se inician en el desarrollo con Spring Boot. El objetivo es mostrar una arquitectura limpia y separada por responsabilidades.

## Estructura de Carpetas

La aplicación sigue el patrón de diseño por capas, lo que facilita el mantenimiento y las pruebas:

1.  **`model/entity`**: Contiene las clases que representan las tablas de la base de datos (Entidades). Aquí definimos qué datos guardamos (nombre, email, edad, etc.).
2.  **`repository`**: Es la capa de acceso a datos. Utiliza Spring Data JPA para realizar operaciones de base de datos de forma sencilla (Guardar, Buscar, Eliminar).
3.  **`service`**: Es donde reside la **lógica de negocio**. Aquí es donde tomamos decisiones, validamos datos y procesamos información antes de guardarla.
4.  **`controller`**: Es la cara pública de nuestra aplicación (REST API). Recibe las peticiones de los usuarios (a través de HTTP) y devuelve las respuestas.

## Tecnologías Utilizadas

- **Java 21**: El lenguaje principal.
- **Spring Boot 4**: El framework que nos facilita todo el "esqueleto" de la aplicación.
- **PostgreSQL**: El sistema de gestión de bases de datos relacionales utilizado para la persistencia.
- **Lombok**: Una herramienta que nos ahorra escribir código repetitivo (como Getters y Setters).

## ¿Cómo ejecutar el proyecto?

1. Asegúrate de tener una instancia de PostgreSQL corriendo.
2. Configura las variables de entorno necesarias (o usa un archivo `.env`):
   - `DB_URL`: La URL de conexión (ej. `jdbc:postgresql://localhost:5432/nombre_bd`).
   - `DB_USERNAME`: Tu usuario de BD.
   - `DB_PASSWORD`: Tu contraseña de BD.
3. Abre tu terminal en la carpeta raíz del proyecto.
4. Ejecuta el comando: `./mvnw spring-boot:run` (en Windows puedes usar `mvnw.cmd`).

---

## Siguientes Pasos
- [Guía de Pruebas de Endpoints](file:///c:/Users/jhonf/Downloads/demo_service/docs/pruebas-de-endpoints.md): Aprende a interactuar con la API.
- [Lógica y Personalización](file:///c:/Users/jhonf/Downloads/demo_service/docs/logica-y-personalizacion.md): Entiende cómo funciona el servicio y el repositorio.
