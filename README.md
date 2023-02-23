# Todo-List-Application
Application in Spring Boot 3 that will store the list of todos in MYSQL database. In the app we can also edit and delete current todos. 

**Setup MySQL**

`docker run --detach --env MYSQL_ROOT_PASSWORD=[your_root_password] --env MYSQL_USER=[your_user] --env MYSQL_PASSWORD=[your_user_password] --env MYSQL_DATABASE=todos --name mysql --publish 3306:3306 mysql:8-oracle`

**Application will be available at:** `localhost:8080`

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
