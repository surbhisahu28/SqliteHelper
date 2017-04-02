package com.example.administrator.sqlitehelper;

/**
 * Created by Administrator on 3/23/2017.
 */

public class Person {

    private int id;
     String name;

    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Person(int id,String name,String address){
        this.id=id;
        this.name=name;
        this.address=address;
    }
}


