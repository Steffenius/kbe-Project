# kbe-Project

### how-to start this app

#### MacOS
* in Terminal go to folder
* enter ```./mvnw spring-boot:run```
* go to your browser and open http://localhost:8080/

#### MS Windows
* in CommandLine go to folder
* enter ```./mvnw spring-boot:run```
* go to your browser and open http://localhost:8080/

#### Using Docker
* ```docker build --build-arg JAR_FILE=target/*.jar -t kbe/productapp .```
* ```docker run -p 8080:8080 kbe/productapp```
* go to your browser and open http://localhost:8080/
