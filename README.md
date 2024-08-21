# core_model_calculator

## Overview

This project consists of a backend Spring Boot application and a frontend served using Nginx. Both components are containerized using Docker and orchestrated with Docker Compose.

## Project Structure

/project-root
├── backend
│ ├── Dockerfile
│ ├── target
│ │ └── backend-0.0.1-SNAPSHOT.jar
│ └── ...
└── frontend
├── Dockerfile
├── index.html
├── app.css
└── app.js

Getting Started
Prerequisites
1. Docker
2. Docker Compose
Building and Running the Containers

Clone the Repository:

git clone https://github.com/your-username/core_model_calculator.git
cd core_model_calculator

Build and Start the Containers:
docker-compose up --build

Access the Applications:

Frontend: Open your browser and navigate to http://localhost. The frontend application will be served here.
Backend: The backend service will be available at http://localhost:8080.

Stop and Remove Containers
docker-compose down
