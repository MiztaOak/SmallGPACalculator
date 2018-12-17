package com.example.mr_goaty_.gpacalculator;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mr_goaty_.gpacalculator.model.Model;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Model model = new Model();

        Button button = findViewById(R.id.button);
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double gpa = model.calculateGPA();
                final TextView text = findViewById(R.id.GPA_Value);
                text.setText("" + gpa + "");
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopup(model);
            }
        });


    }

    public void createPopup(final Model model) {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog, null);
        final EditText etName = alertLayout.findViewById(R.id.et_name);
        final EditText etPoints = alertLayout.findViewById(R.id.et_points);
        final EditText etGrade = alertLayout.findViewById(R.id.et_grade);

        android.support.v7.app.AlertDialog.Builder alert = new android.support.v7.app.AlertDialog.Builder(this);
        alert.setTitle("Add new course");
        // this is set the view from XML inside AlertDialog
        alert.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        alert.setCancelable(false);
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = etName.getText().toString();
                String points = etPoints.getText().toString();
                String grade = etGrade.getText().toString();
                //Toast.makeText(getBaseContext(), "Name: " + name + " Points: " + points + " Grade:" + grade, Toast.LENGTH_SHORT).show();
                if (model.isNumeric(points) && model.isNumeric(grade)) {
                    model.addCourse(name, Integer.parseInt(grade), Double.parseDouble(points));
                }
            }
        });
        android.support.v7.app.AlertDialog dialog = alert.create();
        dialog.show();
    }

}
