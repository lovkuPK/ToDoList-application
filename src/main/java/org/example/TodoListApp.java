package org.example;

import model.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TodoListApp {

    //We have used the ArrayList data structure, because a number of its elements can be
    //extended thanks to the properties of this class
    private final ArrayList<Task> tasks;
    private int taskIdCounter;

    public TodoListApp() {
        tasks = new ArrayList<>();
        taskIdCounter = 1;
    }

    //This method adds a new task to TodoList
    public void addTask(String description) {
        Task newTask = new Task(taskIdCounter++, description);
        tasks.add(newTask);
        System.out.println("Task added: " + newTask);

    }
    //This method marks a task status as completed (the value of variable is set as "true")
    public void markTaskAsCompleted(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setCompleted(true);
                System.out.println("Task marked as completed: " + task);
                return;
            }
        }
        System.out.println("Task not found with ID: " + taskId);
    }

    public void displayTasks() {
        System.out.println("Tasks:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public boolean removeTask(int taskId){
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()){
            Task task = iterator.next();

            if (task.getId() == taskId) {
                iterator.remove();
                System.out.println("Task deleted: " + task);
                return true; // Task successfully removed
            }
        }
        System.out.println("Task not found with ID: " + taskId);
        return false; //Task not found or nor removed
    }

    public static void main(String[] args) {
        // Here is the functionality of main-method of the application
        TodoListApp todoListApp = new TodoListApp();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Display Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); //Consumes newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    todoListApp.addTask(description);
                    break;
                case 2:
                    System.out.print("Enter task ID to mark as completed: ");
                    int taskId = scanner.nextInt();
                    todoListApp.markTaskAsCompleted(taskId);
                    break;
                case 3:
                    todoListApp.displayTasks();
                    break;
                case 4:
                    System.out.println("Enter task ID to delete: ");
                    if (scanner.hasNextInt()) {
                        int taskDeleteId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline character after reading int

                        boolean taskRemoved = todoListApp.removeTask(taskDeleteId);
                        if (taskRemoved) {
                            System.out.println("Task deleted successfully.");
                        } else {
                            System.out.println("Task not found with ID: " + taskDeleteId);
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a valid task ID.");
                        scanner.nextLine(); // Consume invalid input
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}