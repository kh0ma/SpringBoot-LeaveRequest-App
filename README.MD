# SpringBoot LeaveRequest App

## Requirements

* Java 1.8
* Apache Maven 3.3.9
* Git 2.7.4

## Installation

``` $ git clone https://github.com/kh0ma/SpringBoot-LeaveRequest-App ```

``` $ cd SpringBoot-LeaveRequest-App ```

``` $ mvn install ```

## Execution

``` $ mvn spring-boot:run ```

## Description

It is a simple web application that realize spring boot opportunities to work with embedded tomcat.
It can get information from user, evaluate and return information to user.

### Application has next models
1. User: id, name
2. LeaveRequest: id, startDate, endDate, countDays, userId

### Behaviors:
The program get start date and end date from user.
Count days between start date and end date.
Return data to user.
