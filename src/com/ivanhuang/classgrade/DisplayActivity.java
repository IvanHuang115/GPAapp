package com.ivanhuang.classgrade;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		Bundle extras = getIntent().getExtras();

		String className = extras.getString("className");
		TextView tvClassName = (TextView) findViewById(R.id.tvClassName);
		tvClassName.setText(className);

		double desiredGrade = extras.getDouble("desiredGrade");
		Double desiredGradeDouble = new Double(desiredGrade);
		TextView tvDesiredGrade = (TextView) findViewById(R.id.tvDesiredGrade);
		tvDesiredGrade.setText(desiredGradeDouble.toString());

		TextView tvAssignment1 = (TextView) findViewById(R.id.tvAssignment1);
		TextView tvGrade1 = (TextView) findViewById(R.id.tvGrade1);
		TextView tvPercentage1 = (TextView) findViewById(R.id.tvPercentage1);
		String asgn1 = extras.getString("asgn1");
		double grade1 = extras.getDouble("grade1");
		double percentage1 = extras.getDouble("percentage1");
		tvAssignment1.setText(asgn1);
		tvGrade1.setText("Grade: " + new Double(grade1).toString());
		tvPercentage1.setText("Percentage: "
				+ new Double(percentage1).toString());

		TextView tvAssignment2 = (TextView) findViewById(R.id.tvAssignment2);
		TextView tvGrade2 = (TextView) findViewById(R.id.tvGrade2);
		TextView tvPercentage2 = (TextView) findViewById(R.id.tvPercentage2);
		String asgn2 = extras.getString("asgn2");
		double grade2 = extras.getDouble("grade2");
		double percentage2 = extras.getDouble("percentage2");
		tvAssignment2.setText(asgn2);
		tvGrade2.setText("Grade: " + new Double(grade2).toString());
		tvPercentage2.setText("Percentage: "
				+ new Double(percentage2).toString());

		TextView tvAssignment3 = (TextView) findViewById(R.id.tvAssignment3);
		TextView tvGrade3 = (TextView) findViewById(R.id.tvGrade3);
		TextView tvPercentage3 = (TextView) findViewById(R.id.tvPercentage3);
		String asgn3 = extras.getString("asgn3");
		double grade3 = extras.getDouble("grade3");
		double percentage3 = extras.getDouble("percentage3");
		tvAssignment3.setText(asgn3);
		tvGrade3.setText("Grade: " + new Double(grade3).toString());
		tvPercentage3.setText("Percentage: "
				+ new Double(percentage3).toString());

		TextView tvAssignment4 = (TextView) findViewById(R.id.tvAssignment4);
		TextView tvGrade4 = (TextView) findViewById(R.id.tvGrade4);
		TextView tvPercentage4 = (TextView) findViewById(R.id.tvPercentage4);
		String asgn4 = extras.getString("asgn4");
		double grade4 = extras.getDouble("grade4");
		double percentage4 = extras.getDouble("percentage4");
		tvAssignment4.setText(asgn4);
		tvGrade4.setText("Grade: " + new Double(grade4).toString());
		tvPercentage4.setText("Percentage: "
				+ new Double(percentage4).toString());

		AssignmentGrade asgnGrade1 = new AssignmentGrade(asgn1, percentage1,
				grade1);
		AssignmentGrade asgnGrade2 = new AssignmentGrade(asgn2, percentage2,
				grade2);
		AssignmentGrade asgnGrade3 = new AssignmentGrade(asgn3, percentage3,
				grade3);
		AssignmentGrade asgnGrade4 = new AssignmentGrade(asgn4, percentage4,
				grade4);

		ClassGrades classGrades = new ClassGrades(className);
		classGrades.addGrade(asgnGrade1);
		classGrades.addGrade(asgnGrade2);
		classGrades.addGrade(asgnGrade3);
		classGrades.addGrade(asgnGrade4);

		double currentGrade = classGrades.calcGrade();
		double requiredGrade = classGrades.gradeToGet(desiredGrade);
		double percentageCompleted = classGrades.getPercentageCompleted();
		double percentageLeft = 1 - percentageCompleted;

		TextView tvCurrentGrade = (TextView) findViewById(R.id.tvCurrentGrade);
		tvCurrentGrade.setText(new Double(currentGrade).toString());
		TextView tvRequiredGrade = (TextView) findViewById(R.id.tvRequiredGrade);
		tvRequiredGrade.setText(new Double(requiredGrade).toString());
		
		TextView tvPercentageCompleted = (TextView) findViewById(R.id.tvPercentageCompleted);
		tvPercentageCompleted.setText("Percentage Completed: " + new Double(percentageCompleted).toString());
		TextView tvPercentageLeft = (TextView) findViewById(R.id.tvPercentageLeft);
		tvPercentageLeft.setText("Percentage Left: " + new Double(percentageLeft).toString());
	}
	

}
