# Automation Testing for saucedemo.com

## Overview

This repository contains an automation testing project for saucedemo.com, a sample e-commerce website. The project is developed using the following technologies: IntelliJ IDEA, Maven, Java, Selenium, Cucumber, and Gherkin. It is designed to showcase how to perform end-to-end automated testing of a web application using these tools and technologies.

## Technologies Used

- **IntelliJ IDEA**: IntelliJ IDEA is the Integrated Development Environment (IDE) used for writing, managing, and running Java code. In this project, IntelliJ IDEA serves as the IDE for developing and executing testing scripts.

- **Maven**: Maven is a project management and dependency management tool used to automate project setup, dependency management, and build execution. In this project, Maven is used to manage project dependencies and execute testing scenarios.

- **Java**: Java is the programming language used in this project. In the context of automated testing, Java is used to implement the testing code, interact with Selenium WebDriver, and execute testing scenarios.

- **Selenium**: Selenium is a suite of automated testing tools for web applications. Selenium WebDriver enables automated interactions with a website, including clicking links, filling out forms, and verifying web application behavior. In this project, Selenium is used to perform automated user actions on saucedemo.com.

- **Cucumber**: Cucumber is a software testing tool that follows the Behavior-Driven Development (BDD) approach. It allows tests to be written in human-readable language that can be understood by non-technical stakeholders. In this project, Cucumber is used to define testing scenarios in Gherkin language.

- **Gherkin**: Gherkin is a specification language used to write test scenarios in a format that is easy to read by humans. Gherkin is used in conjunction with Cucumber to define steps and expected behaviors in testing.

## Features and Testing

This automation testing project covers several critical features of saucedemo.com. Here's a brief description of each feature being tested:

- **Login**: The login process is tested to ensure that users can log into their accounts successfully. This involves entering login credentials such as username and password and verifying that the user logs in successfully.

- **Add to Cart**: This feature tests whether products can be added to the shopping cart correctly. It includes clicking on a product, adding it to the cart, and verifying that the product is added successfully.

- **Checkout**: The checkout process is tested to ensure that users can complete the purchase of products they have added to the cart. This includes filling out shipping information, verifying the total payment, and completing the transaction.

- **Logout**: The final step is testing the logout process from the user account. This ensures that users can log out of their sessions correctly and return to the login page.

Each of these features has different testing scenarios defined in Gherkin language and implemented in Java code to be executed using Selenium WebDriver.

## Prerequisites

Before getting started with the testing, ensure that you have the necessary software and tools installed as mentioned in the previous section.
