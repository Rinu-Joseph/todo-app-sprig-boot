# Assignment: Build a Personal Task Management Web Application

## Objective
Develop a Spring Boot application that allows users to manage their personal tasks efficiently.

---

## Task Model
The application should include a `Task` model with the following attributes:

- **id**: int  
- **name**: String  
- **description**: String  
- **dueDate**: LocalDate  
- **status**: enum (`PENDING`, `COMPLETED`)  
- **Additional Fields (Optional)**:  
  - createdAt  
  - updatedAt  
  - deleted (boolean / soft delete flag)

---

## API Endpoints

### Create a new task
- **POST** `/api/v1/tasks`

---

### Retrieve all tasks
- **GET** `/api/v1/tasks`

---

### Retrieve a task by ID
- **GET** `/api/v1/tasks/{id}`

---

### Retrieve tasks by status
- **GET** `/api/v1/tasks/status`
- **Query Param Example:**  
