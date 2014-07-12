package com.ivanhuang.classgrade;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*
		 * if (savedInstanceState == null) {
		 * getSupportFragmentManager().beginTransaction() .add(R.id.container,
		 * new PlaceholderFragment()).commit(); }
		 */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	public void onClickCalc(View view) {

		Intent i = new Intent(this, DisplayActivity.class);

		EditText etClassName = (EditText) findViewById(R.id.etClassName);
		String className = etClassName.getText().toString();
		EditText etDesiredGrade = (EditText) findViewById(R.id.etDesiredGrade);
		String desiredGradeString = etDesiredGrade.getText().toString();
		double desiredGrade = toDouble(desiredGradeString);

		i.putExtra("className", className);
		i.putExtra("desiredGrade", desiredGrade);

		// for the assignments, I still have to check that double values are
		// entered in for the grades and percentages
		// ---------------- Assignment 1 ---------------------------- //
		EditText etName1 = (EditText) findViewById(R.id.etAssignment1);
		String asgn1 = etName1.getText().toString();

		EditText etGrade1 = (EditText) findViewById(R.id.etGrade1);
		String grade1String = etGrade1.getText().toString();
		double grade1 = toDouble(grade1String);

		EditText etPercentage1 = (EditText) findViewById(R.id.etPercentage1);
		String percentage1String = etPercentage1.getText().toString();
		double percentage1 = toDouble(percentage1String) / 100;

		i.putExtra("asgn1", asgn1);
		i.putExtra("grade1", grade1);
		i.putExtra("percentage1", percentage1);
		// ---------------------------------------------------------- //

		// ---------------- Assignment 2 ---------------------------- //
		EditText etName2 = (EditText) findViewById(R.id.etAssignment2);
		String asgn2 = etName2.getText().toString();

		EditText etGrade2 = (EditText) findViewById(R.id.etGrade2);
		String grade2String = etGrade2.getText().toString();
		double grade2 = toDouble(grade2String);

		EditText etPercentage2 = (EditText) findViewById(R.id.etPercentage2);
		String percentage2String = etPercentage2.getText().toString();
		double percentage2 = toDouble(percentage2String) / 100;

		i.putExtra("asgn2", asgn2);
		i.putExtra("grade2", grade2);
		i.putExtra("percentage2", percentage2);
		// ---------------------------------------------------------- //

		// ---------------- Assignment 3 ---------------------------- //
		EditText etName3 = (EditText) findViewById(R.id.etAssignment3);
		String asgn3 = etName3.getText().toString();

		EditText etGrade3 = (EditText) findViewById(R.id.etGrade3);
		String grade3String = etGrade3.getText().toString();
		double grade3 = toDouble(grade3String);

		EditText etPercentage3 = (EditText) findViewById(R.id.etPercentage3);
		String percentage3String = etPercentage3.getText().toString();
		double percentage3 = toDouble(percentage3String) / 100;

		i.putExtra("asgn3", asgn3);
		i.putExtra("grade3", grade3);
		i.putExtra("percentage3", percentage3);
		// ---------------------------------------------------------- //

		// ---------------- Assignment 4 ---------------------------- //
		EditText etName4 = (EditText) findViewById(R.id.etAssignment4);
		String asgn4 = etName4.getText().toString();

		EditText etGrade4 = (EditText) findViewById(R.id.etGrade4);
		String grade4String = etGrade4.getText().toString();
		double grade4 = toDouble(grade4String);

		EditText etPercentage4 = (EditText) findViewById(R.id.etPercentage4);
		String percentage4String = etPercentage4.getText().toString();
		double percentage4 = toDouble(percentage4String) / 100;

		i.putExtra("asgn4", asgn4);
		i.putExtra("grade4", grade4);
		i.putExtra("percentage4", percentage4);
		// ---------------------------------------------------------- //

		startActivity(i);

	}

	public double toDouble(String s) {
		double d;
		try {
			d = Double.parseDouble(s);
		} catch (NumberFormatException nfe) {
			d = 0;
		}
		return d;
	}

}
