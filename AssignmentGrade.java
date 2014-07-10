package com.ivanhuang.classgrade;

public class AssignmentGrade implements Comparable<AssignmentGrade> {
	private String assignment; // name of assignment
	private double percentage; // percentage of total grade
	private double grade; // grade received

	// maybe make a copy constructor?

	public AssignmentGrade() {
		assignment = "Empty Assignment";
		percentage = 0;
		grade = 0;
	}

	public AssignmentGrade(String assignmentName,
			double percentageOfTotalGrade, double gradeReceived) {
		assignment = assignmentName;
		percentage = percentageOfTotalGrade;
		grade = gradeReceived;
	}

	public String getAssignment() {
		return assignment;
	}

	public double getPercentage() {
		return percentage;
	}

	public double getGrade() {
		return grade;
	}

	public void setAssignment(String assignmentName) {
		assignment = assignmentName;
	}

	public void setPercentage(double percentageOfTotalGrade) {
		percentage = percentageOfTotalGrade;
	}

	public void setGrade(double gradeReceived) {
		grade = gradeReceived;
	}

	@Override
	public int compareTo(AssignmentGrade toCompare) {
		double diff = toCompare.percentage - this.percentage;
		int intDiff = (int) (diff * 10000);
		return intDiff;
	}

	public void printGrade() {
		System.out.println(assignment + ": percentage: " + percentage
				+ " grade: " + grade);
	}

}
