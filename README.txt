# Time Management JavaFX Application

## Overview
The Time Management App is a JavaFX-based application designed to help users analyze and optimize how they spend their 24-hour day. Users input daily activities such as sleep, study, work, exercise, and leisure time. The application then evaluates the schedule, provides feedback, and suggests improvements based on time balance and productivity.

This project follows the **Model-View-Controller (MVC)** design pattern and uses a **SQLite database** for data persistence.

---

## Features

- Input daily time allocation (sleep, study, work, exercise, leisure)
- Validates that total time equals 24 hours
- Displays schedule breakdown using a pie chart
- Provides:
  - Balance status (Overloaded / Free Time / Perfectly Balanced)
  - Productivity analysis
  - Stress level estimation
- Generates:
  - Personalized recommendations
  - Areas of concern
  - Optimized schedule suggestions

- Automatically saves schedules using SQLite
- Loads the most recent saved schedule when reopening the app
- Navigation between multiple JavaFX scenes

---

## Project Structure (MVC)

- **Model**
  - `ScheduleModel.java`  
    Handles all logic, calculations, and recommendations.

- **View**
  - `Scene1.fxml` – Main menu  
  - `Scene2.fxml` – Input screen  
  - `Scene3.fxml` – Dashboard analysis  
  - `Scene4.fxml` – Recommendations view
  - `Scene5.fxml` – How it works screen  

- **Controller**
  - `Scene1Controller.java`
  - `Scene2Controller.java`
  - `Scene3Controller.java`
  - `Scene4Controller.java`
  - `HowItWorksController.java`
  
### Database Layer

- `DatabaseManager.java`

Handles:
- Creating database tables
- Saving user schedules
- Loading the most recent schedule

---

## Database

This application uses **SQLite** to store user schedules locally.

- Database file: `schedule.db`
- Table name: `schedules`
- Stored values:
  - sleep
  - study
  - work
  - exercise
  - leisure

### Database Behavior

- Automatically creates database on first run
- Saves submitted schedules
- Loads most recent schedule into Scene2 input fields on startup

No internet connection is required.

---

## UML Diagram

A UML diagram of the application structure is included in the repository and demonstrates:

- JavaFX application startup flow
- MVC architecture
- Controller relationships
- Database integration
- FXML scene structure

---

## Requirements

- Java 11 or higher
- JavaFX SDK (configured in your IDE)
- jGRASP / IntelliJ / Eclipse (any JavaFX-supported IDE)
- SQLite JDBC Driver (`sqlite-jdbc.jar`)

---

## How to Run

1. Clone or download the repository.
2. Open the project in jGRASP or another Java IDE.
3. Configure JavaFX libraries.
4. Add the SQLite JDBC `.jar` file to the classpath.
5. Compile the project.
6. Run `TimeManagementApp.java`.