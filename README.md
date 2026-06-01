# 🔑 SPG | Strong Password Generator

> 👨🏻‍💻 **Made by: Murillo Sergio**

![Java Version](https://img.shields.io/badge/java-17-brightgreen)
![Spring Boot](https://img.shields.io/badge/springboot-4.0.6-brightgreen)
![Passay](https://img.shields.io/badge/passay-1.6.4-brightgreen)
![Docker](https://img.shields.io/badge/docker-4c1ed.svg?logo=docker&logoColor=white)

## How works?

This simple API randomly generates a password considered strong (containing uppercase and lowercase letters, numbers, and symbols).

## Endpoints

There is (for now) a single endpoint, “/api/password,” which uses the GET method in HTTP requests.

## How to run the project

```bash
git clone https://github.com/murillosnds/SPG.git
cd SPG
docker build -t spg-app .
docker run -d -p 8080:8080 --name api-password spg-app
# Run http://localhost:8080/api/password?length=16
```

### ⭐ If this project has been helpful to you, please consider giving the repository a star!

This project is licensed under the MIT License.  
See the file [LICENSE](./LICENSE) for more details.