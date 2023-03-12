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
* * **imdb_rating**: de tipo doble, contiene la puntuación de la película en la página https://imdb.com.
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
- _movimientos_, de tipo _List\<String\>_, consultable. Lista de movimientos de la partida.
- _estudio_, de tipo _String_, consultable. Contiene el nombre del estudio que ha creado la película
- _mundial_, de tipo _Boolean_, consultable. Contiene si la película ha sido estrenada a nivel mundial.
- _actores_, de tipo _List_, consultable. Nombre de los principales actores de la película
**Constructores**: 

- C1: Tiene un parámetro por cada propiedad básica del tipo.
- C2: Crea un objeto de tipo ```Movies``` a partir de los siguientes parámetros: ```LocalDate fechaEstreno,Integer duracion,String titulo, Integer recaudacion, Double puntuacion```.

**Restricciones**:
 
- R1: La duración debe estar entre 1 y 60.
- R2: El movimiento inicial debe ser uno de los movimientos siguientes: h3, h4, g3, g4, f3, f4, e3, e4, d3, d4, c3, c4, b3, b4, a3, a4, Nh3, Nf3, Nc3, Na3.
- R3: El rating de las blancas debe ser mayor que cero.
- R4: El rating de las negras debe ser mayor que cero.
***Criterio de igualdad**: Dos partidas son iguales si todas sus propiedades básicas son iguales.

**Criterio de ordenación**: Por fecha, duración y número de movimientos.

**Otras operaciones**:

- _String getMovimiento(Integer numMovimiento)_: Devuelve el movimiento dado por el número numMovimiento. Eleva ```IllegalArgumentException``` si ```numMovimiento``` no está en el intervalo [1, getNumMovimientos()]

#### Tipos auxiliares

- TipoVictoria, enumerado. Puede tomar los valores OUTOFTIME, RESIGN, MATE, DRAW.
- Resultado, enumerado. Puede tomar los valores WHITE, BLACK, DRAW.

### Factoría - FactoriaPartidas
Clase de factoría para construir objetos de tipo Partidas.

- _Partidas leerPartidas(String nomfich)_:Crea un objeto de tipo Partidas a partir de la información recogida en el archivo csv, cuya ruta se da como parámetro.


### Tipo Contenedor - Partidas

Clase contenedora de los objetos de tipo Partida.

**Propiedades**:

-  _partidas_, de tipo _List\<Partida\>_, consultable. Lista de partidas de ajedrez 
-  _numero partidas_, de tipo _Integer_, consultable. Número de partidas del contenedor. 
 
**Constructores**: 

- C1: Constructor por defecto. Creal un objeto de tipo Partidas sin ninguna partida almacenada.
- C2: Constructor con un parámetro de tipo Collection\<Partida\>. Crea un objeto de tipo Partidas con las partidas incluidas en la colección dada como parámetro.
- C3: Constructor con un parámetro de tipo Stream\<Partida\>. Crea un objeto de tipo Partidas con las partidas incluidas en el Stream dado 

**Criterio de igualdad**: Dos partidas son iguales si lo son sus propiedades partidas.


**Otras operaciones**:
- _void agregarPartida(Partida p)_: Añade una partida de ajedrez al objeto.
- _Double getPromedioDuracionesMedias(TipoVictoria vic)_: Devuelve la media de la duración media(en segundos) por turno de las partidas. Si la media no se puede calcular, devuelve cero.
- _Map<String, Double> getPorcentajesSiguienteMovimiento(String movimiento, Integer numeroMovimiento)_: Devuelve un Map en el que las claves son movimientos siguientes al dado como parámetro (según el movimiento y la posición en la que se hace), y los valores el porcentaje de veces que se ha hecho ese movimiento. Por ejemplo,     si el movimiento es "Nc6" y el número de movimiento es el 6, el Map contiene como claves los movimientos hechos en séptimo lugar tras un movimiento "Nc6". Los valores serán el porcentaje de veces que se han hecho esos movimientos. Eleva ```IllegalArgumentException```si numeroMovimiento no es mayor o igual que uno.
- _Double getPorcentajeVictoriasDeApertura(String apertura, Resultado resultado)_: Devuelve el porcentaje de partidas que incluyen la cadena de apertura en su apertura y cuyo resultado es el dado como parámetro.
- _SortedSet<Partida> getNPartidasMasCortas(Integer anyo, Integer n)_: Devuelve un conjunto ordenado con las n partidas más cortas jugadas en el año dado como parámetro. El conjunto estará ordenado por el número de movimientos de la partida.
- _List<String> getNMejoresJugadores(Integer anyo, Integer n)_: Devuelve una lista con los ids de los n jugadores con más victorias en el año dado como parámetro.
- _Long getTiempoTotalJuego(String idJugador)_: Devuelve el total de minutos jugados por el jugador dado como parámetro.
- _String getJugadorMasVictorias(Integer anyo, Resultado resultado)_:
Devuelve true si hay algún jugador que tenga más de n victorias.
- _Map<TipoVictoria, String> getGanadorNPorTipoVictoria(Integer n)_:
Devuelve un map en el que las claves son los tipos de victoria y el valor es el enésimo jugador con más rating entre los jugadores que han tenido victorias de ese tipo. Es decir, si hacemos un ranking de los jugadores según su rating, nos quedaríamos con el que está en la posición n.

