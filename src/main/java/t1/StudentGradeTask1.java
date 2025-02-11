package t1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentGradeTask1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Double> grades = new ArrayList<Double>();
		
		System.out.println("Enter student grades (Type -1 to finish): ");
		
		// Input loop
		while (true) {
			System.out.println("Enter grade: ");
			String input = sc.nextLine().trim(); //Read and trim input
			
			try {
				double grade = Double.parseDouble(input);
				
				if (grade == -1) break;
				
				if (grade < 0 || grade > 100) {
					System.out.println("Invalid grade! Enter a value between 0 and 100.");
				} else {
					grades.add(grade);
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input! Please enter a valid number.");
			}
		}
		
		// If no grades were entered
		if (grades.isEmpty()) {
			System.out.println("No grades entered. Exiting...");
		} else {
			displayStatistics(grades);
		}
		
		sc.close();
	}
	
	public static void displayStatistics(List<Double> grades) {
		double sum = grades.stream().mapToDouble(Double::doubleValue).sum();
		double average = sum / grades.size();
		double highest = Collections.max(grades);
		double lowest = Collections.min(grades);
		
		System.out.println("\n Grade Statistics: ");
		System.out.printf("Average Grade: %.2f%n", average);
		System.out.printf("Highest Grade: %.2f%n", highest);
		System.out.printf("Lowest Grade: %.2f%n", lowest);
	}
	
	
}
