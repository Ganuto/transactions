# Customer Account & Transactions

## Overview

This is a project to serve as a Customer Account & Transactions API. 
It also contains a Dockerfile in order to make it dockerable.

## Prerequisites

- [Java 21+](https://download.oracle.com/java/21/latest/jdk-21_macos-x64_bin.tar.gz)
- [Maven](https://maven.apache.org/install.html) (for building the application)
- [Docker](https://docs.docker.com/get-docker/) (for containerization)

## Getting Started

### Running Locally

Clone the project:

```bash
  git clone https://github.com/Ganuto/transactions.git
```

Go to the project directory:

```bash
  cd transactions
```

Build the application and generate the .jar:

````
./mvnw clean package
````

Then, execute the recently generated .jar:

````
java -jar target/transactions-1.0.0.jar
````

### Running with Docker

#### 1. Build the image

Ensure Docker is running on your machine. Then build the Docker image using the Dockerfile provided:

```
docker build -t transactions .
```

#### 2. Run the image

Once the image is built, you can run the Docker container:

```
docker run -p 8080:8080 transactions
```

This command maps port 8080 on your local machine to port 8080 on the Docker container. You can access the application
at http://localhost:8080.

### Testing

To run only unit tests, use the following Maven command:

```
./mvnw test
```

To run only integration tests, use the following Maven command:

```
./mvnw failsafe:integration-test
```

To run both, unit and integration tests, use the following Maven command:

```
./mvnw verify
```
