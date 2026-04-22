VALIDACIONES DE SERVICE ? R: Que sea null — por si el usuario no manda el teléfono
Que tenga exactamente 10 dígitos — usando .length() != 10

Si no cumple alguna de las dos, lanza una excepción con un mensaje descriptivo. Por ejemplo si mandas "telefono": "123" , el servidor responderá con error 500 y el mensaje "El número de teléfono debe tener exactamente 10 dígitos".

COMO PROBE EL METODO PERSONALIZADO? R: Lo realize con postman buscando usuarios cuya edad esten entre 20 y 30 años siendo 20 el minimo y 30 el maximo retornando los resultados que apliquen a esta 

PRUEBAS REALIZADAS? R:
## 1. Listar todos los Usuarios
**Método:** `GET`  
**Endpoint:** `/api/usuarios
**Ruta:** GET http://localhost:8080/api/usuarios
**Respuesta del servidor:** 200 ok y un arreglo vacio []

## 2. Crear un Nuevo Usuario (Caso Exitoso)
**Método:** `POST`  
**Endpoint:** `/api/usuarios`  
**Cuerpo (JSON):**
```json
{
  "nombre": "mario ayala",
  "email": "mario@example.com",
  "edad": 25
}
```
**ruta:** `POST http://localhost:8080/api/usuarios `  
**Respuesta del servidor:** 200 ok
```json
{
    "id": 1,
    "nombre": "mario ayala",
    "email": "mario@example.com",
    "edad": 25
}
```
## 3. Probar Lógica de Negocio (Caso Fallido)

### A. Menor de edad (Menos de 18 años)
**Método:** `POST`  
**Endpoint:** `/api/usuarios` 
**Cuerpo (JSON):**
**ruta:** `POST http://localhost:8080/api/usuarios `  
```json
{
  "nombre": "emiro",
  "email": "emiro@example.com",
  "edad": 15
}
```
**Respuesta del servidor:** 400Bad Request
Lógica de Negocio: El usuario debe ser mayor de 18 años.

### B. Email Duplicado
**Método:** `POST`  
**Endpoint:** `/api/usuarios` 
**Cuerpo (JSON):**
```json
{
  "nombre": "juan",
  "email": "mario@example.com",
  "edad": 20
}
```
**ruta:** `POST http://localhost:8080/api/usuarios ` 
**Resultado esperado:** 400 Bad Request 
Lógica de Negocio: El email ya está en uso.

## 4. Buscar Usuario por ID
**Método:** `GET`  
**Endpoint:** `/api/usuarios/{id}`
**Ruta**  http://localhost:8080/api/usuarios/1
**Respuesta** 200 ok
```json
{
    "id": 1,
    "nombre": "mario ayala",
    "email": "mario@example.com",
    "edad": 25
}
```
## 5. Buscar por Rango de Edad (Método Personalizado)
**Método:** `GET`  
**Endpoint:** `/api/usuarios/por-edad?min={min}&max={max}`
**Ruta**   http://localhost:8080/api/usuarios/por-edad?min=20&max=30
**Respuesta** 200 ok
```json
[
    {
        "id": 1,
        "nombre": "mario ayala",
        "email": "mario@example.com",
        "edad": 25
    },
    {
        "id": 2,
        "nombre": "juan",
        "email": "mar@example.com",
        "edad": 20
    }
]
```
## 6. Eliminar un Usuario
**Método:** `DELETE`  
**Endpoint:** `/api/usuarios/{id}`
**Ruta**   http://localhost:8080/api/usuarios/1
**Respuesta** 200 ok