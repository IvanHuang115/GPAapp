package com.ivanhuang.classgrade;

import java.util.Iterator;
import java.util.PriorityQueue;

public class ClassGrades {

	private PriorityQueue<AssignmentGrade> gradesList;
	private Iterator<AssignmentGrade> gradeIterator;
	private String className;
	private double percentageCompleted;

	// add a professorName too?

	public ClassGrades() {
		gradesList = new PriorityQueue<AssignmentGrade>();
		gradeIterator = gradesList.iterator();
		className = "Class With No Name";
		percentageCompleted = 0;
	}

	public ClassGrades(String theClass) {
		gradesList = new PriorityQueue<AssignmentGrade>();
		gradeIterator = gradesList.iterator();
		className = theClass;
		percentageCompleted = 0;
	}

	public Iterator<AssignmentGrade> getIterator() {
		return gradeIterator;
	}

	public PriorityQueue<AssignmentGrade> getCopyOfGrades() {
		return new PriorityQueue<AssignmentGrade>(gradesList);
	}

	public String getClassName() {
		return className;
	}

	public double getPercentageCompleted() {
		return percentageCompleted;
	}

	public AssignmentGrade addGrade(AssignmentGrade g) {
		gradesList.add(g);
		percentageCompleted += g.getPercentage();
		return g;
	}

	// might have to change implementation
	public AssignmentGrade removeGrade(AssignmentGrade g) {
		gradesList.remove(g);
		percentageCompleted -= g.getPercentage();
		return g;
	}

	// calculates the grade so far at the given percentageCompleted, does not
	// have to be 100% completed yet
	// percentageCompleted cannot be greater than 1
	public double calcGrade() {
		// does not account for extra credit yet
		if (percentageCompleted > 1)
			return -1;

		double overallGrade = 0;
		PriorityQueue<AssignmentGrade> grades = getCopyOfGrades();

		/*
		 * This gives ConcurrentModificationException Iterator<AssignmentGrade>
		 * i = getIterator(); while (i.hasNext()) { AssignmentGrade g =
		 * (AssignmentGrade) i.next(); overallGrade += g.getPercentage() *
		 * g.getGrade(); }
		 */
		while (!grades.isEmpty()) {
			AssignmentGrade g = grades.remove();
			overallGrade += g.getPercentage() * g.getGrade();
		}
		return (overallGrade / percentageCompleted);
	}

	public double gradeToGet(double gradeWanted) {
		/*
		 * double gradeSoFar = calcGrade(); double perentageLeft = 1 -
		 * percentageCompleted;
		 */
		return (gradeWanted - calcGrade() * percentageCompleted)
				/ (1 - percentageCompleted);

	}
}
