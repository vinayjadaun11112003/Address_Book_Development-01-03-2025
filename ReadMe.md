# 📖 Address Book App

Welcome to the **Address Book App** repository! 🚀

## 📂 About This Repository
This repository contains **all project files** related to the development of the **Address Book App**. 🏠📇

## ✨ Features
- Effortlessly **store, edit, and delete** contacts 📜
- User-friendly **interface** 🎨
- Secure **data management** 🔒
- Fast and responsive **performance** ⚡

## 📌 Installation
To get started, clone the repository and install dependencies:
```sh
$ git clone https://github.com/your-repo/address-book-app.git
$ mvn spring-boot:run
```

## 🚀 Usage

Run the backend server with:
```sh
$ mvn spring-boot:run
```
Section 1: Address Book App Setup UC1 - Setting Up Spring Boot Project Created a Spring Boot project using Spring Initializr Configured MySQL database in application.properties Tested REST API using cURL Issue: MySQL driver error → Fixed by adding the correct dependency in pom.xml

UC2 - Creating REST Controller & Database Connection Implemented a REST Controller to handle HTTP methods Configured MySQL Database Connection Used ResponseEntity for proper JSON responses Tested REST calls (GET, POST, PUT, DELETE) using cURL Issue: MySQL dependency error → Fixed by explicitly adding mysql-connector-java

Section 2: Handling AddressBook DTO & Model UC1 - Introducing DTO and Model Created DTO and Model classes for Address Book Defined a few basic fields (e.g., name, phone, email) Used ResponseEntity to format API responses Tested REST API using cURL

UC2 - Introducing Service Layer Moved business logic from Controller to Service Layer Used @Autowired for Dependency Injection Controller now delegates requests to Service Layer

UC3 - Storing Data in Memory (Temporary) Added in-memory storage (List) to store Address Book entries Implemented CRUD operations in Service Layer (GET, POST, PUT, DELETE) Used AtomicLong to generate unique IDs Tested all API calls using cURL Modification: Renamed service methods to prevent conflicts:

addEntry() → createAddressEntry() updateEntry() → modifyAddressEntry() deleteEntry() → removeAddressEntry() Updated Controller to call renamed service methods
## 🛠️ Technologies Used
### Backend:
- **Java Spring Boot** ☕
- **Spring Data JPA** 🗄️
- **MySQL / PostgreSQL** 🛢️

## 📜 License
This project is **open-source** and available under the **MIT License**.

---
📬 For any queries, feel free to reach out! 😊 Happy Coding! 💻

