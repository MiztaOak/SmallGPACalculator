package com.example.mr_goaty_.gpacalculator.model;

public class Course {
    private double grade;
    private  double points;
    private String name;

    public Course(String name, double points, double grade){
        this.points = points;
        this.grade = grade;
        this.name = name;
    }

    public Course(String name, double points){
        this(name,points,0);
    }

    public double getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
