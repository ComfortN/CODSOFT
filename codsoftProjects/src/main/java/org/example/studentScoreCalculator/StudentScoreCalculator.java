package org.example.studentScoreCalculator;

import java.util.Scanner;

public class StudentScoreCalculator {


    /**
     * Reads the marks for all subjects from the user input and returns an array of marks.
     *
     * @param scanner Scanner object for user input.
     * @return An array of marks entered by the user.
     */
    public static int[] enterMarks(Scanner scanner) {
        System.out.println("Enter the marks for all subjects: ");
        int subjects = 0;
        while (subjects <=0) {
            System.out.println("How many subjects: ");
            subjects = scanner.nextInt();

        }
        int[] marks = new int[subjects];
        for (int i = 0; i < subjects; i++) {
            System.out.println("Enter marks for subject " + (i+1) + ": ");
            marks[i] = scanner.nextInt();
        }
        return marks;
    }


    /**
     * Calculates and returns the average percentage based on the total marks and the number of subjects.
     *
     * @param total   Total marks obtained.
     * @param numOfSubjects Number of subjects.
     * @return The average percentage.
     */
    public static double averagePercentage(int total, int numOfSubjects) {

        return (double) total / numOfSubjects;
    }


    /**
     * Calculates and returns the total marks based on the array of marks.
     *
     * @param marks An array of marks for various subjects.
     * @return The total marks.
     */
    public  static int calcMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }


    /**
     * Determines and returns the grade based on the average percentage.
     *
     * @param avePercent The average percentage.
     * @return The corresponding grade.
     */
    public static String calcGrades(double avePercent) {
        if (avePercent >= 90) {
            return "Outstanding Achievement";
        } else if (avePercent >= 80) {
            return "Outstanding Achievement";
        } else if (avePercent >= 70) {
            return "Meritorious Achievement";
        } else if (avePercent >= 60) {
            return "Substantial Achievement";
        } else if (avePercent >= 50) {
            return "Adequate Achievement";
        } else if (avePercent >= 40) {
            return "Moderate Achievement";
        } else if (avePercent >= 30) {
            return "Elementary Achievement";
        } else {
            return "Not Archived";
        }
    }


    /**
     * Displays the total marks, average percentage, and grade to the console.
     *
     * @param total    Total marks obtained.
     * @param avePercent The average percentage.
     * @param grades   The calculated grade.
     */
    public static void displayMarks(int total, double avePercent, String grades) {

        System.out.println("Results: ");
        System.out.println("Total Marks: " + total);
        System.out.println("Ave percentage: " + avePercent + "%");
        System.out.println("Grades: " + grades);
    }


    /**
     * Main method for running the student score calculation program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] marks = enterMarks(scanner);
        int total = calcMarks(marks);
        double avePercent = averagePercentage(total, marks.length);
        String grade = calcGrades(avePercent);


        displayMarks(total,avePercent,grade);

        scanner.close();
    }
}
