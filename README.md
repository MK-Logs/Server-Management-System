# Server Management App - Course Project

This is a Server Management Application that allows for the creation, deletion, update, search, and pinging of servers within the network. The System is compartmentalized into frontend and backend components. The Frontend was developed using Angular, HTML, and CSS. The Backend was developed using the Spring Boot framework and is connected with a MySQL database. The two components integrate and communicate via the specified localhost IP. The backend is self-contained and can be coupled with different frontend frameworks and designs such as React or Django templates.
  
Service Functionalities: Create, List, Get, Update, Delete, Ping  

# Backend Design

The server model details provided by the management system was formatted with the required field values. Then, the service interface for the server was developed with the required functions. For the implementation of the server service, the service class implemented the service interface methods. Moving forward, a response model was developed to map the HTTP responses. The application data was manually created with different Server IP addresses and names. Lastly, a JDBC connection was established to a MySQL database to populate and save the generated server data.
  
# Frontend Design

The interface of the backend server was developed such that requests and responses can be mapped both with regards to the server service and HTTP interaction. Then, server service injection was carried out. The UI logic was created using HTML and Bootstrap. Element ng-container was used to showcases different UIs based on application state. Lastly, the different app components were implemented corresponding to the service functionalities created in the backend. 
