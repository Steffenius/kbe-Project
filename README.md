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
* * in CommandLine/Terminal go to folder
* ```docker build --build-arg JAR_FILE=target/*.jar -t pineappleproducts .```
* ```docker run -p 8080:8080 pineappleproducts```
* go to your browser and open http://localhost:8080/
