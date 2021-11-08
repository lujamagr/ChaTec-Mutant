# PROYECTO - IS-MUTANT  
###### Por Luis Javier Martinez

## Introducción

El proyecto is-mutant busca realizar la verificación por medio de la cadena ADN de un individuo y validar así si tiene patrones que lo clasifican como mutante o como humano.

## Descripción

Se hace entrega de un API Rest que recibe una cadena a evaluar y como respuesta se puede obtener lo siguiente.


###### 1. Código respuesta 200 ok - el cual corresponde a la cadena ADN de un mutante.

###### 2. Código respuesta 403 Forbiden - el cual corresponde a una cadena de ADN de un humano.

------------
### Ejecución de la API

##### Prueba NIVEL 2

Debe contar con una herramienta de test para servicio tal como Postman, SoapUI o cualquiera del mercado.

Paso 1.
Descarga / Instala Postman del sitio https://www.postman.com/

Paso 2.
Crear una nueva colección con el nombre“Proyecto Mutant”
Crea un nuevo request dentro de esta colección que se creó.

Paso 3.
Coloca un nombre al nuevo resquest.
Selecciona Método POST y pega en frente la siguiente ruta : https://luis-project-mutant.uc.r.appspot.com/api/v1/mutant

Paso 4.
Selecciona la pestaña body, luego la opción raw y luego la opción JSON.

Paso 5.
Pega el siguiente código en el área de mensaje

{
“dna”:[“ATGCGA”,”CAGTGC”,”TTATGT”,”AGAAGG”,”CCCCTA”,”TCACTG”]
}

-> Altere y pruebe distintas secuencias más de una vez para registrar mayor información en BD.

NOTA: Cada cadena será evaluada por el API, en caso de primera vez que se evalúa será guardado en un registro de base de datos, de lo contrario no será guardada.

Por último, debe dar clic en el botón SEND para invocar la API y obtener el resultado.

##### Prueba NIVEL 3

Paso 1.
Descarga / Instala Postman del sitio https://www.postman.com/

Paso 2.
Crea un nuevo request dentro de la colección que se creó en la prueba NIVEL 2.

Paso 3.
Coloca un nombre al nuevo resquest.
Selecciona Método GET y pega en frente la siguiente ruta: https://luis-project-mutant.uc.r.appspot.com/api/v1/stats

Paso 4.
Clic en el botón SEND y obtenga la respuesta.

Ejemplo:
{
“count_mutant_dna”: 1,
“count_human_dna”: 1,
“ratio”: 1.0
}










