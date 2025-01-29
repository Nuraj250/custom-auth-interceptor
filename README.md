# Custom Annotation in Spring Boot with JWT Authentication

## 📌 What is this project?

This project demonstrates how to create a **custom annotation** in a Spring Boot application while implementing **JWT-based authentication**. The custom annotation `@InjectUserContext` allows automatic injection of user details (like username and roles) into API methods, simplifying authentication and authorization workflows. The project also includes:

- **Spring Security** for authentication and authorization.
- **JWT (JSON Web Token)** for secure API access.
- **H2 in-memory database** for easy testing.
- **Aspect-Oriented Programming (AOP)** to handle the custom annotation.
- **Global Exception Handling** for better error management.

It is a complete authentication system that demonstrates best practices for user authentication and role-based access control in Spring Boot.

## 🚀 How to Run Your Spring Boot Project (With Custom Annotation & JWT Authentication)

Now that your project is set up correctly, follow these **step-by-step instructions** to run and test your application.

---

## 🔹 1️⃣ Ensure Your Environment is Ready

Before running the project, make sure you have:

- ✅ **Java 17** (or the version specified in `pom.xml`)
- ✅ **Maven Installed** (`mvn -v` to check)
- ✅ **IntelliJ IDEA / VS Code / Eclipse** (Any Java IDE)
- ✅ **Postman / cURL** (for API testing)

---

## 🔹 2️⃣ Build & Run the Application

### **Option 1: Using Your IDE (IntelliJ / Eclipse / VS Code)**

1. Open the project in **IntelliJ IDEA** (or your preferred IDE).
2. Navigate to the `CustomAnnotationApplication.java` class.
3. Click Run ▶️ OR use the shortcut:

Mac: Cmd + Shift + F10

Windows/Linux: Ctrl + Shift + F10



### **Option 2: Using Maven (Terminal)**

Run the following commands in the project root directory:

```sh
# 1️⃣ Clean previous builds (optional)
mvn clean

# 2️⃣ Build the project
mvn install

# 3️⃣ Run the application
mvn spring-boot:run
```

Your **Spring Boot application** should now start on **`http://localhost:8080`**.

---

## 🔹 3️⃣ Verify the H2 Database (Optional)

Since we are using **H2 in-memory database**, you can check the database via **H2 Console**:

- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

Click **Connect** to view the `users` table.

---

## 🔹 4️⃣ Test API Endpoints (Authentication & Custom Annotation)

Now let's test your APIs using **Postman** or **cURL**.

### **📌 Login API (Get JWT Token)**

#### **POST `http://localhost:8080/api/auth/login`**

##### **Request Body (JSON)**

```json
{
  "username": "admin",
  "password": "admin123"
}
```

##### **Response (JSON)**

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5..."
}
```

✅ **Copy this token** for the next requests.

---

### **📌 Access Secured API (`@InjectUserContext` Custom Annotation)**

#### **GET `http://localhost:8080/api/auth/me`**

##### **Headers**

```text
Authorization: Bearer <PASTE_YOUR_JWT_HERE>
```

##### **Response (JSON)**

```json
{
  "username": "admin",
  "roles": "ROLE_ADMIN"
}
```

If you don’t send a token, you should get:

```json
{
  "error": "Unauthorized"
}
```

✅ **This confirms that the JWT authentication and custom annotation are working.**

