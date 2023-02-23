# Todo-List-Application
Application in Spring Boot 3 that will store the list of todos in MYSQL database. In the app we can also edit and delete current todos. 

# How to launch an application?

1. **Setup MySQL**

###### `docker run --detach --env MYSQL_ROOT_PASSWORD=root1234 --env MYSQL_USER=janir --env MYSQL_PASSWORD=root --env MYSQL_DATABASE=todos --name mysql --publish 3306:3306 mysql:8-oracle`

###### *`MYSQL_ROOT_PASSWORD`, `MYSQL_USER` and `MYSQL_PASSWORD`* can be changed to your own preference. I have used the same as in `src/main/resources/application.properties`

2. **Launch the application**

##### It will be in `src\main\java\pl\poznan\put\demo\DemoApplication.java`.

3. **Open a browser**

##### Application will be available at: `localhost:8080`

**Technologies used:**
* Java 19
* Spring Boot 3
* Spring Security
* Spring Dev Tools
* Spring Data JPA
* Spring Hibernate
* Bootstrap 5
* MySQL 8
* Docker
