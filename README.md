# Tarea 3 – Estructura de Datos, Maven y Ofuscación

## Descripción

Este repositorio contiene dos proyectos Maven dentro del mismo repositorio:

1. **umg.edu.gt.data-structure.stack**  
   Librería que implementa manualmente una estructura de datos tipo pila (`LinkedStack`).

2. **stackHandler**  
   Aplicación que consume la librería y valida expresiones algebraicas utilizando la pila implementada.

En esta práctica se aplican los siguientes conceptos:

- Gestión de dependencias con Maven  
- Instalación de librería en repositorio local  
- Consumo de librería desde otro proyecto  
- Implementación manual de estructura de datos (pila)  
- Validación de expresiones algebraicas  
- Ofuscación reproducible con Maven (ProGuard)  
- Ingeniería inversa de JAR ofuscado  
- Pruebas funcionales desde consola  


## Requisitos

- Java 11  
- Maven 3.x  
- JD-GUI (para ingeniería inversa)  


## Estructura del Repositorio

```text
Tarea3Progra3/
│
├── umg.edu.gt.data-structure.stack/
├── stackHandler/
├── evidencias/
└── README.md
```


## 🛠 Compilación desde cero

### 1️ Compilar e instalar la librería

```bash
cd umg.edu.gt.data-structure.stack
mvn clean install
```

Esto instala la librería en el repositorio local de Maven (`.m2`).

### 2️ Compilar el proyecto principal

```bash
cd ../stackHandler
mvn clean package
```

Se generará el archivo:

```
target/stackHandler-1.0.0.jar
```


## Ejecución desde consola

```bash
java -jar target/stackHandler-1.0.0.jar "(a+b) * [c-d]"
```

### Ejemplo de salida:

```text
(a+b) * [c-d] -> true
([)] -> false
```


## Ofuscación reproducible

Ambos proyectos incluyen un perfil Maven llamado:

```text
obfuscate
```

### Generar JAR ofuscado en la librería

```bash
cd umg.edu.gt.data-structure.stack
mvn clean package -Pobfuscate
```

Se generará:

- `data-structure-stack-1.0.0-obfuscado.jar`
- `proguard_map.txt`
- `proguard_seed.txt`

### Generar JAR ofuscado en stackHandler

```bash
cd ../stackHandler
mvn clean verify -Pobfuscate
```

Se generará:

- `stackHandler-1.0.0-obfuscado.jar`
- `proguard_map.txt`
- `proguard_seed.txt`


## Prueba de regresión

Se ejecutó el JAR normal y el JAR ofuscado desde consola para comprobar que el comportamiento no cambia.

```bash
java -jar target/stackHandler-1.0.0.jar "(a+b) * [c-d]"
java -jar target/stackHandler-1.0.0-obfuscado.jar "(a+b) * [c-d]"
```

El resultado es idéntico en ambos casos, confirmando que la ofuscación no afecta la funcionalidad.


## Parte D – Ingeniería Inversa 

Se utilizó **JD-GUI** para decompilar el JAR ofuscado.

Al analizar el código decompilado se observa que:

- Las clases fueron renombradas a identificadores cortos como `a`, `b`, `c`.  
- Los métodos también fueron renombrados.  
- Se pierde claridad semántica y estructural.  
- Sin embargo, la lógica general del programa sigue siendo comprensible.  
- El comportamiento del sistema no cambia tras la ofuscación.  

Esto demuestra que la ofuscación protege parcialmente la legibilidad del código sin afectar su ejecución.


## Evidencias 

La carpeta `evidencias/` contiene:

- Compilación exitosa de ambos proyectos  
- Generación de JAR normal y ofuscado  
- Ejecución desde consola  
- Prueba de regresión  
- Capturas de ingeniería inversa  
- Archivo `proguard_map.txt` mostrando el renombrado de clases  
