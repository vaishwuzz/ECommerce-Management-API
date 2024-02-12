# ECommerce-Management-API

# ECommerce Management API

## Overview

This project is a Spring Boot-based REST API for managing products in an e-commerce platform. It supports CRUD operations for products, with attributes such as ProductID, Name, Description, Price, and Quantity Available.

## Features

- **Create Product:**
  - Input: Product details (Name, Description, Price, Quantity Available)
  - Output: Product details (ProductID, Name, Description, Price, Quantity Available) or an error message if creation fails.

- **Read Product:**
  - Input: ProductID of the product to retrieve
  - Output: Product details (ProductID, Name, Description, Price, Quantity Available) or an error message if the product is not found.

- **Update Product:**
  - Input: Product details (ProductID, Name, Description, Price, Quantity Available) or an error message if update fails.
  - Output: Success/Failure message

- **Delete Product:**
  - Input: ProductID of the product to delete
  - Output: Success/Failure message

- **Apply Discount or Tax:**
  - Input: ProductID, Discount Percentage OR Tax Rate (client can choose either discount or tax), and applicable value
  - Output: Success/Failure message, Updated Product details (including modified price)

## Getting Started

### Prerequisites

- Java
- Spring Boot
- Maven

### Building and Running the Project

1. Clone the repository:

   ```bash
   git clone https://github.com/vaishwuzz/ECommerce-Management-API.git
Navigate to the project directory:

bash
Copy code
cd ECommerce-Management-API
Build and run the project:

bash
Copy code
mvn spring-boot:run
API Endpoints
Create Product:

POST /api/products
Read Product:

GET /api/products/{productId}
Update Product:

PUT /api/products/{productId}
Delete Product:

DELETE /api/products/{productId}
Apply Discount or Tax:

POST /api/products/{productId}/apply-discount or /api/products/{productId}/apply-tax
License
This project is licensed under the MIT License.
