# Todo-List-Application
Application in Spring Boot 3 that will store the list of todos in MYSQL database. In the app we can also edit and delete current todos.

**How to run MYSQL database:**
`docker run --detach --env MYSQL_ROOT_PASSWORD=[your_root_password] --env MYSQL_USER=[your_user] --env MYSQL_PASSWORD=[your_user_password] --env MYSQL_DATABASE=todos --name mysql --publish 3306:3306 mysql:8-oracle`

**Technologies used:**
* Java 17
* Spring Boot 3
* Spring JPA
* Spring Hibernate
* Bootstrap 5
* MySQL 8
* Docker
