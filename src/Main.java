// Jeremy Spence 1660, 2/27/25

import java.util.ArrayList;
import java.util.Scanner;

class ToDoList {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nPlease choose an option:\n(1) Add a task.\n(2) Remove a task.\n(3) Update a task.\n(4) List all tasks.\n(5) List tasks by priority.\n(0) Exit.");
            try {
                int option = scanner.nextInt();
                switch (option) {
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
                    case 5:
                        listTasksByPriority();
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    private static void addTask() {
        scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        int priority = -1;
        while (priority < 0 || priority > 5) {
            try {
                System.out.print("Enter priority (0-5): ");
                priority = scanner.nextInt();
                if (priority < 0 || priority > 5) {
                    System.out.println("Priority must be between 0 and 5.");
                }
            } catch (Exception e) {
                System.out.println("Invalid priority. Please enter a number between 0 and 5.");
                scanner.nextLine();
            }
        }

        Task task = new Task(title, description, priority);
        tasks.add(task);
    }

    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }
        listTasks();
        try {
            System.out.print("Task number to remove: ");
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
                System.out.println("Task removed.");
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid task number.");
            scanner.nextLine();
        }
    }

    private static void updateTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to update.");
            return;
        }
        listTasks();
        try {
            System.out.print("Task number to update: ");
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index < tasks.size()) {
                scanner.nextLine();
                System.out.print("Enter new title: ");
                String title = scanner.nextLine();

                System.out.print("Enter new description: ");
                String description = scanner.nextLine();

                int priority = -1;
                while (priority < 0 || priority > 5) {
                    try {
                        System.out.print("Enter new priority (0-5): ");
                        priority = scanner.nextInt();
                        if (priority < 0 || priority > 5) {
                            System.out.println("Priority must be between 0 and 5.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid priority. Please enter a number between 0 and 5.");
                        scanner.nextLine();
                    }
                }

                Task task = new Task(title, description, priority);
                tasks.set(index, task);
                System.out.println("Task updated.");
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid task number.");
            scanner.nextLine();
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

    private static void listTasksByPriority() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.print("Enter priority level to filter (0-5): ");
        int priority = scanner.nextInt();

        if (priority < 0 || priority > 5) {
            System.out.println("Priority must be between 0 and 5.");
            return;
        }

        boolean found = false;
        for (Task task : tasks) {
            if (task.getPriority() == priority) {
                System.out.println(task);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No tasks found with the specified priority.");
        }
    }
}