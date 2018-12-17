package com.example.mr_goaty_.gpacalculator.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Course> courses;

    public Model(){
        courses = new ArrayList<>();
    }

    public void addCourse(String name, int grade, double points){

        courses.add(new Course(name,points,grade));
    }

    public double calculateGPA(){
        double sumPoints = 0;
        double totalPoints = 0;

        for (Course c: courses){
            sumPoints += c.getPoints();
            totalPoints += c.getPoints() * c.getGrade();
        }

        return ((double)Math.round((totalPoints / sumPoints)*1000)/1000);
    }
    public  boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

}
