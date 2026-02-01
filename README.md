# Java Console Order Management System

## 📌 Overview

This project is a **Java console-based Order Management System** designed to demonstrate solid **Object-Oriented Programming (OOP)** principles, clean code organization, and real-world business rules — all **without using a database**.

The application simulates a small order workflow where users can create customers, products, and orders, add items to orders, manage order status, and view order summaries.

---

## 🎯 Purpose

The main goal of this project is to practice and showcase:

- Object-Oriented Programming (OOP)
- Clean architecture and separation of concerns
- Business rule enforcement
- Java Collections (`Map`, `List`)
- Enums for domain modeling
- Console-based user interaction
- In-memory data management (no database)

This project is suitable for **learning purposes, technical assessments, and portfolio demonstration**.

---

## 🛠️ Technologies & Concepts Used

- **Java** (Java 8+)
- Java Collections (`HashMap`, `ArrayList`)
- `UUID` for entity identification
- `LocalDateTime` for date and time handling
- Enums for domain states
- Exception handling
- Layered structure (Application, Services, Entities)

---

## 🗂️ Project Structure

src/main/java/
├── application
│ ├── Main.java
│ └── ConsoleApp.java
├── entities
│ ├── Cliente.java
│ ├── Produto.java
│ ├── Pedido.java
│ └── ItemPedido.java
├── services
│ ├── ClienteService.java
│ ├── ProdutoService.java
│ └── PedidoService.java
├── enums
│ ├── CategoriaProduto.java
│ └── StatusPedido.java
└── utils
└── ConsoleInput.java


---

## ⚙️ Application Features

- Create customers
- Create products with categories
- Create orders linked to customers
- Add items to orders
- Calculate order total automatically
- Manage order lifecycle:
  - OPEN
  - PAID
  - CANCELED
- Prevent invalid operations through business rules
- Display detailed order summary
- Fully interactive console menu

---

## 🧠 Business Rules Implemented

- Orders start with status **OPEN**
- Items can only be added to **OPEN** orders
- Paid orders cannot be modified or canceled
- Orders without items cannot be paid
- Item subtotal is calculated from product price × quantity
- Order total is the sum of all item subtotals

---

## ▶️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/java-console-order-system.git

## Example Console Output

1 - Create Customer
2 - Create Product
3 - Create Order
4 - Add Item to Order
5 - Pay Order
6 - Cancel Order
7 - View Order
0 - Exit


## 🚀 Future Improvements

Add unit tests (JUnit)

Use BigDecimal for monetary values

Persist data using a database (JPA/Hibernate)

Expose functionality via REST API (Spring Boot)

Improve reporting features

## 👨‍💻 Author

Developed as a learning and portfolio project to practice Java backend fundamentals and clean software design.
