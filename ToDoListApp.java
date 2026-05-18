import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- To-Do List Menu ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String task = scanner.nextLine().trim();
                    if (!task.isEmpty()) {
                        tasks.add(task);
                        System.out.println("Task added!");
                    } else {
                        System.out.println("Task cannot be empty.");
                    }
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks yet.");
                    } else {
                        System.out.println("Your tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to remove.");
                    } else {
                        System.out.println("Current tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }

                        System.out.print("Enter task number to remove: ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Please enter a valid number: ");
                            scanner.next();
                        }
                        int removeIndex = scanner.nextInt();
                        scanner.nextLine();

                        if (removeIndex >= 1 && removeIndex <= tasks.size()) {
                            tasks.remove(removeIndex - 1);
                            System.out.println("Task removed.");
                        } else {
                            System.out.println("Invalid task number.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1 to 4.");
            }

        } while (choice != 4);

        scanner.close();
    }
}