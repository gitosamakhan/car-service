# Car Service Project
`Spring Boot 🍀` `MongoDB 💿` `Apache Kafka 🕸` `Docker 🐳`

<hr/>

The project design is added as a `design.drawio` file in the project repository as well.

![Design](/design.png)

## How to make changes
To make changes in the code:
* After making your changes, run 

        gradle clean build

    This will create new jars for microservices in the project

* Remove previous images for spring-boot microservices:

        docker images 
        docker image rm image-id

* To start docker containers, run:

        docker compose up

    This will start all the containers.