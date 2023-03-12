# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso 2022/23)
Autor/a: Pablo Vargas Sáez   uvus:RTG6354

## Estructura de las carpetas del proyecto

* **/src**: Directorio con el código fuente.
  * **fp**: Paquete que contiene los tipos del proyecto.
  * **fp.test**: Paquete que contiene las clases de test del proyecto.
  * **utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset del proyecto.
    * **blockbusters.csv**: Archivo csv que contiene datos de diferentes películas.
    
## Estructura del *dataset*

El dataset original Top 10 Highest Grossing Films (1975-2018) se puede obtener de la URL(https://www.kaggle.com/datasets/bidyutchanda/top-10-highest-grossing-films-19752018) Originalmente tiene 11 columnas y cada fila contiene datos sobre una película. A continuación se describen las 11 columnas del dataset:

* **Main_Genre**: de tipo cadena,  indica el género principal de la película.
* **Genre_2**: de tipo cadena, indica el segundo género de la película.
* **Genre_3**: de tipo cadena, indica el tercer género de la película.
* **imdb_rating**: de tipo doble, contiene la puntuación de la película en la página https://imdb.com.
* **rank_in_year**: de tipo cadena, indica la posición en el ranking de peliculas de ese año.
* **length**: de tipo entero, tiene la duración en minutos de la duración de la película.
* **rating**: de tipo doble, contiene la puntuación de la película de los usuarios. 
* **studio**: de tipo cadena, contiene el estudio que ha hecho la película.
* **title**: de tipo cadena, indica el título de la película.
* **worldwide_gross**: de tipo cadena, indica los dolares recaudados con la película.
* **year**: de tipo entero. Indica el año del estreno de la película.

## Tipos implementados

Los tipos que se han implementado en el proyecto son los siguientes:

### Tipo Base - Movies
Representa una película concreta.
**Propiedades**:

- _fechaEstreno_, de tipo _LocalDate_, consultable. Indica la fecha de estreno de la película. 
- _tipo_, de tipo _TipoSaga_, consultable. Indica el tipo de película. Puede tomar los valores PELÍCULA, SAGA.
- _tematica_, de tipo _String_, consultable. Indica la temática de la película.
- _puntuacion_, de tipo _Double_, consultable. Contiene la puntuación de la película de los usuarios. .
- _duracion_, de tipo _Integer_, consultable. Contiene la duración en minutos de la duración de la película.
- _titulo_, de tipo _String_, consultable. Contiene el título de la película.
- _recaudacion_, de tipo _Integer_, consultable. Contiene indica los dolares recaudados con la película.
- _estudio_, de tipo _String_, consultable. Contiene el nombre del estudio que ha creado la película
- _mundial_, de tipo _Boolean_, consultable. Contiene si la película ha sido estrenada a nivel mundial.
- _actores_, de tipo _List\<String\>_, consultable. Lista con los nombres de los principales actores de la película.
**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Crea un objeto de tipo ```Movies``` a partir de los siguientes parámetros: ```LocalDate fechaEstreno,Integer duracion,String titulo, Integer recaudacion, Double puntuacion```.

**Restricciones**:
 
- R1: La duración debe ser mayor o igual que uno (duracion >= 1).
- R2: La recaudación debe tener valores positivos (recaudacion >= 0).
- R3: La puntuación no puede ser negativa (puntuacion >=0).
***Criterio de igualdad**: Dos películas son iguales si todas sus propiedades básicas son iguales.

**Criterio de ordenación**: Por fecha de estreno.

**Propiedades derivadas**:
-AñoProduccion = Obtiene el año de estreno de la película.
-Popularidad = Devuelve "Éxito" o "No éxito" dependiendo si la pelicula tiene 8.0 de puntuación o menos.
#### Tipos auxiliares

- TipoSaga, enumerado. Puede tomar los valores PELÍCULA,SAGA.

