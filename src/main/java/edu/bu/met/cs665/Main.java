/**
 * Name: Tianfu Xu
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/07/2023
 * File Name: Main.java
 * Description: The `Main` class serves as the entry point of the Java program. It contains the `main` method, which is automatically executed when the program is run. This method orchestrates the program's flow, interacts with other classes, and handles user input. In this application, it displays a menu, reads user choices, and calls appropriate methods from the `TaskScheduler` class.
 */
package edu.bu.met.cs665;

import java.util.Scanner;
import edu.bu.met.cs665.example1.TaskScheduler;
import edu.bu.met.cs665.example1.Task;
import edu.bu.met.cs665.example1.User;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskScheduler taskScheduler = new TaskScheduler();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Create Task");
            System.out.println("2. Assign Task to User");
            System.out.println("3. Cancel Task");
            System.out.println("4. Show All with Users");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter task ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter task name: ");

                    String name = scanner.nextLine();
                    scanner.nextLine();

                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    taskScheduler.createTask(id, name, description);
                    break;

                case 2:
                    System.out.print("Enter task ID: ");
                    int taskId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Task task = taskScheduler.getTaskById(taskId);
                    if (task != null) {
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        User user = new User(username);
                        taskScheduler.assignTaskToUser(task, user);
                    } else {
                        System.out.println("Invalid task ID.");
                    }
                    break;

                case 3:
                    System.out.print("Enter task ID to cancel: ");
                    int taskIdCancel = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Task taskToCancel = taskScheduler.getTaskById(taskIdCancel);
                    if (taskToCancel != null) {
                        taskScheduler.cancelTask(taskToCancel);
                    } else {
                        System.out.println("Invalid task ID.");
                    }
                    break;

                case 4:
                    taskScheduler.showAllWithUsers();
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}