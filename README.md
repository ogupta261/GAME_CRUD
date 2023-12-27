# Welcome to Om's Game CRUD Application!

To build a backend service “Game CRUD”.\
A back-end service for CRUD API's for 'GAME'.\
Tech Stack : Java | Spring Boot | H2

On local run, Access the application here : [Game-CRUD](http://localhost:8070/)


## “GAME” Table Schema :

**ID** : BIGINT (SEQUENCE\
**NAME** : VARCHAR\
**URL** : VARCHAR\
**AUTHOR** : VARCHAR\
**PUBLISHED_DATE** : DATE


## API’s built :

 | FUNCTION           | METHOD | API           | QUERY PARAMETERS | BODY           | RETURNS          | 
 | --- | --- | --- | --- | --- | --- |
 | Create Single Game | POST   | /createGame   | NA	              | Game (object)  | Game (object)    | 
 | Read Single Game   | GET	   | /getGame      | ID (long)        | NA             | Game (object)    | 
 | Get All Games      | GET	   | /getAllGames  | NA               | NA             | ArrayList (game) | 
 | Update Single Game | PUT	   | /updateGame   | ID (long)        | Game (object)  | 	Game (object)   | 
 | Delete Single Game | DELETE | /deleteGame   | ID (long)        | NA             | 	String          | 
 | Swagger UI	        | NA     | /swagger.html | NA               | NA             | 	NA              | 
 | H2                 | NA     | /h2           | NA               | NA             | 	NA              | 


#Add_Some_Swagger
