/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.petdatabase;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;

public class PetDatabase {

    public static final int PETS_MAX = 5;
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); 
        boolean running = true;                    
        
        ArrayList<Pet> pets = new ArrayList<>();
        String filename = "pets.txt";
        loadPetsFromFile(pets, "pets.txt");
                
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
            scanner.nextLine(); 
            
            if (choice == 1) {
                if (pets.isEmpty()) {
                    System.out.println("No pets found.");               
                }
                else {
                    System.out.println("+----------------------+");
                    System.out.println("|  ID  |   NAME   |  AGE  |");
                    System.out.println("+----------------------+");
                    for (Pet pet : pets) {
                        System.out.println("|   " + pet.getID() + "  |  " + pet.getName() + "   |  " + pet.getAge() + "  | ");
                    }
                    System.out.println("+----------------------+");
                }
            }
            
            else if (choice ==2) {
               
                if (pets.size() >= PETS_MAX) {
                    System.out.println("Maximum number of pets have been reached.");
                    continue;
                }
                
                int count = 0;
                
                while (true) {
                    if (pets.size() == PETS_MAX){
                        System.out.println("Database is full.");
                        break;
                    }
                    
                    String name;
                    while (true) {
                        System.out.print("Enter pet name (or type 'done' to finish): ");
                        name = scanner.nextLine().trim();

                        if (name.equalsIgnoreCase("done")) {                       
                            break; 
                    }
                    
                       if (name.isEmpty()) {
                           System.out.println("Pet name can't be empty. Please try again.");
                           continue;
                       }
                       break;
                    }
                   int age;
                   while (true) {
                        System.out.print("Enter pet age (1-20): ");
                        if (scanner.hasNextInt()) {
                           age = scanner.nextInt();
                           scanner.nextLine(); 
                           if (age >= 1 && age <= 20) {
                               break;
                           }
                           else {
                               System.out.println("Invalid age. Should be between 1-20. Try again.");
                           }
                        }
                        else {
                            scanner.nextLine();
                            System.out.println("Invalid entry. Please enter a number between  1 and 20.");
                        }
                   }             
                    pets.add(new Pet(pets.size(), name, age));
                    count++;
                }
                
                savePetsToFile(pets, filename);
                System.out.println("Pets saved to file.");
                System.out.println(count + " pets added.");
            }
            
            else if (choice == 3) {
                int updateID;
                    while (true) {
                        System.out.print("Enter the ID of the pet to update: ");
                        if (scanner.hasNextInt()) {
                            updateID = scanner.nextInt();
                            scanner.nextLine(); 

                        if (updateID >= 0 && updateID < pets.size()) {
                            break; 
                        } 
                        else {
                            System.out.println("Invalid ID. Must be between 0 and " + (pets.size() - 1) + ".");
                        }
                    }   
                    else {
                        scanner.nextLine(); 
                        System.out.println("Invalid input. Please enter a number.");
                    }
                    }

                boolean idFound = false;
            
                for (Pet pet: pets) {
                    if (pet.getID() == updateID) {
                        System.out.println("Enter a new name: ");
                        String newName = scanner.nextLine();
                        
                        System.out.println("Enter a new age: ");
                        int newAge = scanner.nextInt();
                        scanner.nextLine();
                        
                        pet.setName(newName);
                        pet.setAge(newAge);
                        
                        System.out.println("Pet has been updated!");
                        idFound = true;
                        break;
                    }
                }
                if (!idFound) {
                    System.out.println("No pet found with that ID.");
                }
            }
            else if (choice == 4) {
                int removeID;
                while (true) {
                    System.out.println("Enter the ID of the pet you'd like to delete.");
                    if (scanner.hasNextInt()) {
                        removeID = scanner.nextInt();
                        scanner.nextLine();
                        if (removeID >= 0 && removeID < pets.size()) {
                            break;
                        }
                        else {
                            System.out.println("Invalid ID. Please try again.");
                        }
                    }
                    else {
                        scanner.nextLine();
                        System.out.println("Invalid input. Please try again.");
                    }
                }

                boolean removed = false;
                
                for (int i = 0; i < pets.size(); i++) {
                    if (pets.get(i).getID() == removeID) {
                        pets.remove(i);
                        System.out.println("Pet removed successfully!");
                        removed = true;
                        break;
                    }
                }
                if (!removed) {
                    System.out.println("No pet found with that ID.");
                }
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

    
    //Save pets to file
        public static void savePetsToFile(ArrayList<Pet> pets, String filename) {
            try {
                PrintWriter writer = new PrintWriter(filename);

                for (Pet pet : pets) {
                writer.println(pet.getID());
                writer.println(pet.getName());
                writer.println(pet.getAge());
                }

            writer.close();
            }
            catch (Exception e) {
                System.out.println("Error saving to file.");
            }
        }
        
      //Load pets from file
        public static void loadPetsFromFile(ArrayList<Pet> pets, String filename) {
            try {
                Scanner fileScanner = new Scanner(new File(filename));

                while (fileScanner.hasNextInt()) {
                    int id = fileScanner.nextInt();
                    fileScanner.nextLine(); 

                    String name = fileScanner.nextLine();
                    int age = fileScanner.nextInt();
                    fileScanner.nextLine(); 

                    pets.add(new Pet(id, name, age));
                }

            fileScanner.close();
            }   
            catch (Exception e) {
                System.out.println("No existing file found."); //start a brand new file
            }
        }
}
