/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.petdatabase;

import java.util.Scanner;
import java.util.ArrayList;

public class PetDatabase {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); 
        boolean running = true;                    
        
        ArrayList<Pet> pets = new ArrayList<>();
        
        while (running) {

            System.out.println("Welcome to Pet Database Program!");
            System.out.println("Choose an option:");
            System.out.println("1) View all pets");
            System.out.println("2) Add more pets");
            System.out.println("3) Update an existing pet");
            System.out.println("4) Remove an existing pet");
            System.out.println("5) Search pets by name");
            System.out.println("6) Search pets by age");
            System.out.println("7) Exit program");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clears newline
            
            if (choice == 1) {
                if (pets.isEmpty()) {
                    System.out.println("No pets found.");               
                }
                else {
                    System.out.println("+----------------------+");
                    System.out.println("|  ID  |   NAME   |  AGE  |");
                    System.out.println("+----------------------+");
                    for (Pet pet : pets) {
                        System.out.println("|   " + pet.getID() + "  |  " + pet.getName() + "   |  " + pet.getAge() + "  1 | ");
                    }
                    System.out.println("+----------------------+");
                }
            }
            
            else if (choice ==2) {
                int count = 0;
                while (true) {
                    System.out.print("Enter pet name (or type 'done' to finish): ");
                    String name = scanner.nextLine();

                    if (name.equalsIgnoreCase("done")) {
                        break; // exit the add-pet loop
                    }
                    
                   System.out.print("Enter pet age: ");
                   int age = scanner.nextInt();
                   scanner.nextLine();
                    
                    pets.add(new Pet(pets.size(), name, age));
                    count++;
                }
                System.out.println(count + " pets added.");
            }
            
            else if (choice == 3) {
                //code here
            }
            else if (choice == 4) {
                //code here
            }
            else if (choice == 5) {
                System.out.println("Enter name of the pet you want to search: ");
                String searchName = scanner.nextLine();
                
                boolean nameFound = false;
                
                for (Pet pet : pets) {
                    if (pet.getName().equalsIgnoreCase(searchName)) {
                        System.out.println(
                        "ID: " + pet.getID() +
                        " Name: " + pet.getName() +
                        " Age: " + pet.getAge()
                        );
                        nameFound = true;
                    }
                }
                if (!nameFound) {
                    System.out.println("No pets found with that name.");
                }
            }
            else if (choice == 6) {
                System.out.println("Enter age of the pet you would like to search: ");
                int searchAge = scanner.nextInt();
                scanner.nextLine();
                
                boolean ageFound = false;
                
                for (Pet pet: pets) {
                    if (pet.getAge() == searchAge) {
                        System.out.println(
                        "ID: " + pet.getID() +
                        " Name: " + pet.getName() +
                        " Age: " + pet.getAge());
               
                    ageFound = true;
                }
                }
                if (!ageFound) {
                    System.out.println("No pets found with that age.");
            }
        }
            else if (choice == 7) {
                System.out.println("Goodbye!");
                running = false; //exit program
            } 
            else {
                System.out.println("Incorrect input. Try again.");
            }
        }
    }
}
