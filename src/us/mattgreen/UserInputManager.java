package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInputManager {

    private ArrayList<Talkable> zoo;

    public UserInputManager(ArrayList<Talkable> zoo) {
        this.zoo = zoo;
    }

    public void addEntity(Scanner scanner) {
        System.out.println("What type of entity do you want to create? (Dog/Cat/Teacher)");
        String entityType = scanner.nextLine().toLowerCase();

        try {
            switch (entityType) {
                case "dog":
                    System.out.println("Enter the name of the dog:");
                    String dogName = scanner.nextLine();
                    System.out.println("Is the dog friendly? (true/false)");
                    boolean dogFriendly = Boolean.parseBoolean(scanner.nextLine());
                    zoo.add(new Dog(dogFriendly, dogName));
                    break;
                case "cat":
                    System.out.println("Enter the name of the cat:");
                    String catName = scanner.nextLine();
                    System.out.println("Enter the number of mice killed:");
                    int miceKilled = Integer.parseInt(scanner.nextLine());
                    zoo.add(new Cat(miceKilled, catName));
                    break;
                case "teacher":
                    System.out.println("Enter the name of the teacher:");
                    String teacherName = scanner.nextLine();
                    System.out.println("Enter the age of the teacher:");
                    int age = Integer.parseInt(scanner.nextLine());
                    zoo.add(new Teacher(age, teacherName));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid entity type.");
            }
            System.out.println("Entity added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format. Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}