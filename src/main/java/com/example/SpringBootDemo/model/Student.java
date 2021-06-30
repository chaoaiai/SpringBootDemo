package com.example.SpringBootDemo.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    private String id;
    @Column
    private String title;

    public Student(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Student() {

    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
