// Jeremy Spence 1660, 2/4/25

import java.util.ArrayList;
import java.util.Scanner;

class ToDoList {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nPlease choose an option:\n(1) Add a task.\n(2) Remove a task.\n(3) Update a task.\n(4) List all tasks.\n(0) Exit.");
            switch (scanner.nextInt()) {
                case 1:
                    addTask();
                    break;
                case 2:
                    removeTask();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    listTasks();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addTask() {
        scanner.nextLine(); // consume newline
        System.out.print("Enter task: ");
        tasks.add(scanner.nextLine());
    }

    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }
        listTasks();
        System.out.print("Task number to remove: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < tasks.size()) tasks.remove(index);
        else System.out.println("Invalid task number.");
    }

    private static void updateTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to update.");
            return;
        }
        listTasks();
        System.out.print("Task number to update: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < tasks.size()) {
            scanner.nextLine(); // consume newline
            System.out.print("New task description: ");
            tasks.set(index, scanner.nextLine());
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}