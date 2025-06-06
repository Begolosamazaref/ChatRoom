# ChatRoom Application

## Overview
ChatRoom is a real-time messaging application built with Java, leveraging advanced technologies including JavaFX, JDBC, Socket Programming, Multi-Threading, and SQL. The application follows a client-server architecture to enable real-time communication between multiple users.

## Features
- **User Authentication**: Secure login and signup functionality
- **Real-time Messaging**: Instant message delivery using Socket Programming
- **User Status Management**: Track online/offline status of users
- **Message History**: Save and load chat history
- **User Management**: Admin interface for managing users (add, update, delete)
- **Modern UI**: Built with JavaFX for an intuitive user experience

## Project Structure
The project is divided into two main components:

### Client (Chatroom)
- User interface for chat functionality
- Login and registration screens
- Real-time message display
- User status management

### Server
- Socket server for handling client connections
- User authentication and management
- Database operations
- Message broadcasting

## Technology Stack
- **Java**: Core programming language
- **JavaFX**: UI framework for desktop application
- **JDBC**: Database connectivity for user data storage
- **Socket Programming**: For real-time communication between clients and server
- **Multi-Threading**: Handling multiple client connections simultaneously
- **MySQL**: Database for storing user information and chat history

## How It Works
1. The server starts and listens for client connections on port 5005
2. Clients connect to the server using the server's IP address
3. Users can register or login with their credentials
4. Upon successful authentication, users can send and receive messages in real-time
5. Messages are broadcast to all connected clients
6. User status (online/offline) is tracked and updated in the database
7. Chat history can be saved to a local file

## Setup Instructions

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- MySQL Server
- Maven for dependency management

### Database Setup
1. Create a MySQL database named `itiproject`
2. Use the following credentials:
   - Username: root
   - Password: root
3. Create the required tables:
   ```sql
   CREATE TABLE user_information (
     user_id INT AUTO_INCREMENT PRIMARY KEY,
     user_name VARCHAR(50) NOT NULL,
     pass VARCHAR(50) NOT NULL,
     statuse BOOLEAN DEFAULT FALSE
   );
   
   CREATE TABLE admine (
     admin_id INT AUTO_INCREMENT PRIMARY KEY,
     user_name VARCHAR(50) NOT NULL,
     pass VARCHAR(50) NOT NULL
   );
   ```

### Running the Application
1. Start the Server:
   - Navigate to the Server directory
   - Run the Server application: `java -jar Server.jar`
   
2. Start the Client:
   - Navigate to the Chatroom directory
   - Run the Client application: `java -jar Chatroom.jar`
   - Update the server IP address in the Clinte.java file if needed (currently set to "192.168.42.1")

## Implementation Details

### Server Components
- **Server.java**: Main server class that accepts client connections
- **ChatHandler.java**: Handles individual client connections and message broadcasting
- **DAO.java**: Data Access Object for database operations
- **DataBase.java**: Database connection management
- **UserInfo.java**: User information management
- **ServerInterface.java**: Admin interface for server management

### Client Components
- **HelloApplication.java**: Main client application entry point
- **Clinte.java**: Handles socket connection to the server
- **ChatroomController.java**: Controls the chat interface
- **HelloController.java**: Controls the login interface
- **SignUpController.java**: Controls the registration interface
- **DBUtils.java**: Utility functions for scene switching

## Demo
A video demonstration of the application is available in the repository: `ChatRoom.mp4`
