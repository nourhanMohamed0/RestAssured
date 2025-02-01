Welcome to the Pet Store API Testing project repository! 🚀

This repository contains test cases for the Pet Store API using RestAssured, a powerful Java library for testing RESTful web services. The project demonstrates best practices for API automation testing, including validating endpoints, status codes, response payloads, and headers.

Key Features:
Automated Test Suite: Covers core functionalities of the Pet Store API such as user creation, pet management, and order processing.
Comprehensive Test Cases:
Validate system responses for successful and failed operations.
Ensure the integrity of response headers and payloads.
Verify API behavior for edge cases (e.g., missing fields, incorrect methods).

Test Coverage:
User Module:
Create new users with valid and invalid data.
Retrieve existing users by username.
Validate proper error handling for non-existing users.
Pet Module:
Add new pets to the inventory.
Update and retrieve pet details.
Validate operations with invalid data or IDs.
Store Module:
Place new orders for pets.
Validate inventory and order processing.
General Tests:
Ensure correct status codes and response times.
Validate headers and content types.
Test invalid HTTP methods for each endpoint.
Technologies Used:
RestAssured: API testing framework.
TestNG: Test execution and reporting.
Maven: Dependency management.
Java: Programming language for implementation.
