# 🐾 Petstore API Automation Challenge

## 📖 Problem Statement
The **Swagger Petstore** provides a public REST API to manage pets, stores, and users.  
Your challenge is to **design and implement an automated test suite** that validates the **Pet lifecycle (CRUD)** using **Cucumber (BDD)** and **Rest Assured** in Java.

### Why?
- Manual testing is error-prone and slow.
- APIs evolve, and we need **repeatable, automated regression tests**.
- BDD helps teams describe API behavior in a way that’s **understandable for both developers and testers**.

---

## 🎯 What You Need to Build
Create automated tests that:
1. **Create** a new pet (with random data).
2. **Read** the pet by its ID and validate it matches the created data.
3. **Update** the pet’s status (e.g., from `available` → `sold`).
4. **Delete** the pet.
5. Confirm fetching the deleted pet returns **404**.

### Extra Credit
- Add **negative tests** (e.g., invalid pet ID, invalid body).
- Validate **JSON contract/schema** for responses.
- Use **tags** (`@smoke`, `@negative`) to selectively run scenarios.
- Generate **HTML + JSON reports**.

---

## 🔧 Tech Stack
- **Java 21+**
- **Maven 3.8+**
- **Cucumber (BDD)**
- **Rest Assured**
- **JUnit 5**
- **DataFaker** for random test data
- **JSON Schema Validator**

---

## 📦 Setup

### 1. Clone this repo
```bash
git clone git@github.com:Kakapa98/petstore-api-automation.git
cd <repo-name>
```
---

## TESTER
### Mpho Alphios Mofokeng (Kakapa98)
---