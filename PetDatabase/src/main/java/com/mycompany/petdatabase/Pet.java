/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.petdatabase;

/**
 *
 * @author alexs
 */
public class Pet {
    private int id;
    private String name;
    private int age;
    
    public Pet (int id, String name, int age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    public int getID() {return id;}
    public String getName() {return name;}
    public int getAge() {return age;}
    
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

}


