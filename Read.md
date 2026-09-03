# Encryption and Decryption Demo

A simple Spring Boot project demonstrating **AES-256 encryption and decryption** using a REST API.

The application reads data, encrypts it using an AES-256 key, converts the encrypted bytes into Base64 so the ciphertext can be easily viewed, and stores the encrypted data in a file. The application can then decrypt the ciphertext and restore the original data.

> **Note:** This project is a basic encryption/decryption demonstration. AES is standard symmetric encryption and is being used here as a starting point before implementing Homomorphic Encryption in the FYP.

---

## Technologies Used

* Java 21
* Spring Boot
* Spring Web
* AES-256 Encryption
* REST API
* Base64 Encoding
* File Handling

---

## Project Structure

```text
encryptiondecryption-demo
│
├── src
│   └── main
│       └── java
│           └── com.Encryptiondemo.encryptiondecryption.demo
│               │
│               ├── applications
│               │   └── EncryptiondecryptionDemoApplication.java
│               │
│               ├── controllers
│               │   └── encryptioncontroller.java
│               │
│               ├── services
│               │   ├── encryption.java
│               │   ├── decryption.java
│               │   └── keyGenerator.java
│               │
│               └── models
│                   └── readData.java
│
├── Encrypteddata.txt
├── decrypted.txt
├── pom.xml
└── README.md
```

### Package Explanation

#### `applications`

Contains the main Spring Boot application.

```text
EncryptiondecryptionDemoApplication.java
```

This is where the Spring Boot application starts.

---

#### `controllers`

Contains the REST API controller.

```text
encryptioncontroller.java
```

It provides the API endpoints:

```text
POST /api/encryption
POST /api/decryption
```

The controller receives the request and calls the appropriate service.

---

#### `services`

Contains the main encryption and decryption logic.

**`keyGenerator.java`**

Generates and stores the AES-256 secret key.

**`encryption.java`**

Takes the original data and encrypts it using AES.

The encrypted bytes are converted to Base64 so they can be stored and viewed as text.

**`decryption.java`**

Reads the encrypted Base64 data, converts it back to encrypted bytes, and decrypts it using the same AES key.

---

#### `models`

Contains the class responsible for reading the original and encrypted data.

```text
readData.java
```

---

## How the Application Works

The basic flow is:

```text
Original Data
     │
     ▼
Encryption Service
     │
     ▼
AES-256 Encryption
     │
     ▼
Encrypted Bytes
     │
     ▼
Base64 Encoding
     │
     ▼
Encrypteddata.txt
```

For decryption:

```text
Encrypteddata.txt
     │
     ▼
Read Base64 Data
     │
     ▼
Base64 Decode
     │
     ▼
AES-256 Decryption
     │
     ▼
Original Data
     │
     ▼
decrypted.txt
```

---

# How to Run

## 1. Requirements

Make sure you have installed:

* Java 21
* IntelliJ IDEA
* Maven
* Git

Check Java:

```bash
java -version
```

You should see Java 21.

---

## 2. Clone the Repository

Clone the project from GitHub:

```bash
git clone <repository-url>
```

Then enter the project folder:

```bash
cd encryptiondecryption-demo
```

---

## 3. Open the Project

Open the project in **IntelliJ IDEA**.

Wait for Maven to download and load all dependencies.

The dependencies are defined in:

```text
pom.xml
```

---

## 4. Run the Application

Open:

```text
src/main/java/com/Encryptiondemo/encryptiondecryption/demo/applications/EncryptiondecryptionDemoApplication.java
```

Run:

```java
EncryptiondecryptionDemoApplication
```

When the application starts successfully, Spring Boot will run on:

```text
http://localhost:8080
```

---

# Testing the API

You can use **Postman** to test the endpoints.

## Encryption

Send:

```text
POST http://localhost:8080/api/encryption
```

No request body is required for the current implementation.

The application will:

1. Read the original data.
2. Generate/use the AES-256 key.
3. Encrypt the data.
4. Convert the ciphertext to Base64.
5. Save the ciphertext to `Encrypteddata.txt`.
6. Return the ciphertext in the response.

Example response:

```text
8Jf7kL2m9.......
```

The returned value is the encrypted data in Base64 format.

---

## Decryption

Without restarting the Spring Boot application, send:

```text
POST http://localhost:8080/api/decryption
```

The application will:

1. Read the ciphertext from `Encrypteddata.txt`.
2. Decode the Base64 data.
3. Decrypt it using the AES-256 key.
4. Restore the original text.
5. Save the result to `decrypted.txt`.
6. Return the original data in the response.

---

# Important

The current `keyGenerator` generates the AES key when the Spring Boot application starts.

Therefore, for this demo:

```text
Start application
       ↓
Generate AES key
       ↓
Run encryption
       ↓
Run decryption
```

Do **not restart the application between encryption and decryption**, because restarting generates a new key.

For a real production system, the encryption key would need to be stored and managed securely.

---

# API Summary

| Method | Endpoint          | Purpose      |
| ------ | ----------------- | ------------ |
| POST   | `/api/encryption` | Encrypt data |
| POST   | `/api/decryption` | Decrypt data |

---

# Project Goal

This project is a starting point for a larger **FYP involving Homomorphic Encryption and Fault Tolerance**.

The current AES implementation is used to understand the basic concepts of:

* Encryption
* Ciphertext
* Secret keys
* Decryption
* File handling
* REST APIs

The next stage will involve implementing **Homomorphic Encryption**, where computations can be performed on encrypted data without decrypting it first.
