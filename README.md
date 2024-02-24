# Car Service Project
`Spring Boot 3 🍀` `MongoDB 💿` `Apache Kafka 🕸` `Docker 🐳` `Java 17 ☕️`

<hr/>

The project design is added as a `design.drawio` file in the project repository as well.

![Design](/design.png)

## Concepts
This project has:
* Multi module gradle project setup to run multiple microservices.
* Make use of a library among multiple microservices.
* Working docker-compose file for all resources including microservices.

## How to make changes
To make changes in the code:
* After making your changes, run 

        gradle clean build

    This will create new jars for microservices in the project

* Remove previous images for spring-boot microservices:
        
        docker ps -a
        docker rm container-id
        docker images 
        docker image rm image-id

* To start docker containers, run:

        docker compose up

    This will start all the containers.
* If anything goes wrong with kafka, mongo and zk containers, just delete the containers and start docker-compose again.