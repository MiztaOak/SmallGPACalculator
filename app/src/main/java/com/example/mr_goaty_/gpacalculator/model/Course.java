package com.example.mr_goaty_.gpacalculator.model;

public class Course {
    private int grade;
    private  double points;
    private String name;

    public Course(String name, double points, int grade){
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
