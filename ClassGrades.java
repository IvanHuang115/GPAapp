import java.util.Iterator;
import java.util.PriorityQueue;


public class ClassGrades {
	
	private PriorityQueue<GradeChunk> gradesList;
	private Iterator<GradeChunk> gradeIterator;
	private String className;
	private double percentageCompleted;
	
	// add a professorName too?
	
	public ClassGrades() {
		gradesList = new PriorityQueue<GradeChunk>();
		gradeIterator = gradesList.iterator();
		className = "Class With No Name";
		percentageCompleted = 0;
	}
	
	public ClassGrades(String theClass) {
		gradesList = new PriorityQueue<GradeChunk>();
		gradeIterator = gradesList.iterator();
		className = theClass;
		percentageCompleted = 0;
	}
	
	public Iterator<GradeChunk> getIterator() {
		return gradeIterator;
	}
	
	public PriorityQueue<GradeChunk> getCopyOfGrades() {
		return new PriorityQueue<GradeChunk>(gradesList);
	}
	
	public String getClassName() {
		return className;
	}
	
	public double getPercentageCompleted() {
		return percentageCompleted;
	}
	
	
// ------------------------------------------------------------------------------------------------------- //
	class GradeChunk implements Comparable<GradeChunk>{
		private String assignment; // name of assignment
		private double percentage; // percentage of total grade
		private double grade; // grade received
		
		// maybe make a copy constructor?
		
		public GradeChunk() {
			assignment = "Empty Assignment";
			percentage = 0;
			grade = 0;
		}
		
		public GradeChunk(String assignmentName, double percentageOfTotalGrade, double gradeReceived) {
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
		
		public void setGrade (double gradeReceived) {
			grade = gradeReceived;
		}
		
		@Override
		public int compareTo(GradeChunk toCompare) {
			double diff = toCompare.percentage - this.percentage;
			int intDiff = (int) (diff*10000);
			return intDiff;	
		}
		
		public void printGrade() {
			System.out.println(assignment+": percentage: "+percentage+" grade: "+grade);
		}
		
	}
// ------------------------------------------------------------------------------------------------------- //

	public GradeChunk addGrade(GradeChunk g) {
		gradesList.add(g);
		percentageCompleted += g.getPercentage();
		return g;
	}
	
	// might have to change implementation
	public GradeChunk removeGrade(GradeChunk g) {
		gradesList.remove(g);
		percentageCompleted -= g.getPercentage();
		return g;
	}
	
	// calculates the grade so far at the given percentageCompleted, does not have to be 100% completed yet
	// percentageCompleted cannot be greater than 1
	public double calcGrade() {
		// does not account for extra credit yet
		if (percentageCompleted > 1)
			return -1;
		
		double overallGrade = 0;
		PriorityQueue<GradeChunk> grades = getCopyOfGrades();
		
		/* This gives ConcurrentModificationException
		Iterator<GradeChunk> i = getIterator();
		while (i.hasNext()) {
			GradeChunk g = (GradeChunk) i.next();
			overallGrade += g.getPercentage() * g.getGrade();
		}
		*/
		while (!grades.isEmpty()) {
			GradeChunk g = grades.remove();
			overallGrade += g.getPercentage() * g.getGrade();
		}
		return (overallGrade / percentageCompleted);
	}
	
	public double gradeToGet(double gradeWanted) {
		/*
		double gradeSoFar = calcGrade();
		double perentageLeft = 1 - percentageCompleted;
		*/
		return (gradeWanted - calcGrade() * percentageCompleted)/(1-percentageCompleted);
		
	}
	
	// TODO MAKE GPA CALCULATOR METHOD, LOWEST GRADE TO GET AN A METHOD
// ------------------------------------------------------------------------------------------------------- //
	public static void main(String[] args) {
		ClassGrades grades = new ClassGrades();
		ClassGrades.GradeChunk g = grades.new GradeChunk("PSA 1", 0.50, 95);
		grades.addGrade(g);
		grades.addGrade(grades.new GradeChunk("PSA 2", 0.35, 100));
		grades.addGrade(grades.new GradeChunk("PSA 3", 0.20, 85));
		
		grades.removeGrade(g);
		
		
		PriorityQueue<GradeChunk> p = grades.getCopyOfGrades();
		while (!p.isEmpty()) {
			GradeChunk gg = p.remove();
			gg.printGrade();
		}
		
		System.out.println("Overall Grade: "+grades.calcGrade());
		System.out.println("Grade to get: "+grades.gradeToGet(90));
		
		/*
		GradeChunk gg = grades.gradesList.remove();
		gg.printGrade();
		GradeChunk a = grades.gradesList.remove();
		a.printGrade();
		grades.gradesList.remove().printGrade();
		*/
	}
}
