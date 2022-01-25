# Proyecto ACME 
Proyecto creado con la finalidad de contribuir a la toma de desiciones de la companía ACME.
## Descripción general
Este software ha sido desarrollado bajo el lenguaje de programación JAVA. Permite determinar cuantos espacios comunes existen en los horarios que sus empleados de acuerdo a información cargada en un archivo externo en formato `txt`.

### Entrada de datos para el programa
Los siguientes son ejemplos de formatos de datos de entrada para el archivo `txt`:
```sh
RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00
ASTRID=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
ANDRES=MO10:00-12:00,TH12:00-14:00,SU20:00-21:00
```
- `RENE` corresponde nombre del empleado
- `MO` corresponde a la abreviatura del día de la semana (MO = Lunes)
- `10:00-12:00` corresponde a la hora de ingreso y hora de salida respectivamente

El formato deberá tener una línea por empleado y podrá contener la cantidad de empleados que se requieran analizar.

## Arquitectura
El software se ha diseñado bajo una arquitectura MVC. Esta estructura se menciona a continuación:
#### Modelo

Incluye clases que representan la persistencia y estructura de los datos del software. También incluye clases que se encargan de acceder a los mismos. Estas son:
- Bloque
- Empleado
- BloqueDao
- EmpleadoDao

### Servicios
Estos servicios se encargan de realizar las transacciones para el software. Estos son:
- EmpleadoService
- BloqueService

### Controlador
Se encarga de "coordinar" la lógica del software en cuanto a la ejecución de las diferentes actividades tales como:
- Leer archivo externo
- Procesar información del archivo externo
- Utilizar los servicios
- Utilizar clases auxiliares (utilidades)

### Utilidades
Estas clases ayudan en la realización de las tareas. Se han implementado tareas para procesar fechas y procesar archivos externos.

## Enfoque SOLID
Se ha utilizado este enfoque para el diseño del software, por lo tanto su estructura:
- Delega responsabilidades únicas. Cada clase tiene sus responsabilidades claras y definidas
- Hace uso de interfaces
- Tareas segregadas
- Inyección de dependencias

## Compilación del código fuente
Para la compilación del código fuente se requiere la instalación y configuración de JDK-12. A través del siguiente enlace podrá guiarse en este proceso: [http://somebooks.es/instalar-jdk-windows-10/]

```sh
Utilice su IDE de preferencia para efectuar esta acción
```

## Ejecución del programa de forma local
Para la ejecución del programa de forma local se hace necesaria la instalación de Java Virtual Machine en [https://www.java.com/en/download/]. 
Los pasos para la ejecución del programa de forma local son:
- Copie el proyecto ubicado en XXXXXXXXXX
- Dentro del proyecto encuentra un archivo denominado `input.txt`. Ubique este archivo en ``C:\``
- Utilice el símbolo del sistema para ubicarse en la carpeta `IOET Test`
- Escriba el siguiente comando:
```sh
java -jar ioetTest.jar
```
El software mostrará en consola la salida algo similar a esto:
```sh
RENE-ASTRID: 2
RENE-ANDRES: 2
ASTRID-ANDRES: 3
```





