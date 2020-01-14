package com.example.schedulista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.schedulista.ui.login.DatabaseHelper;

import java.util.ArrayList;
import android.widget.Button;
public class Registration extends AppCompatActivity {


    DatabaseHelper mydb ;
    EditText editName, editEmail,editPassword,editContact;
    Button register = findViewById(R.id.register);
    String city,editGender;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        final Spinner spinner = (Spinner)findViewById(R.id.City);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Jamnagar");
        arrayList.add("Rajkot");
        arrayList.add("Ahmedabad");
        arrayList.add("Baroda");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                city = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });







    }
    public void addData()
    {
        register.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        editName = (EditText)findViewById(R.id.FullName);
                        editEmail = (EditText)findViewById(R.id.Email);
                        editPassword = (EditText)findViewById(R.id.Password);
                        RadioGroup rg = (RadioGroup)findViewById(R.id.Gender);
                        int id = rg.getCheckedRadioButtonId();
                        RadioButton rb  = (RadioButton)findViewById(id);
                        editGender = rb.getText().toString();
                        editContact = (EditText)findViewById(R.id.contact);

                        boolean isInserted = mydb.insertData(editName.getText().toString(),editEmail.getText().toString(),editPassword.getText().toString(),city,editGender,editContact.getText().toString());
                        if(isInserted == true)
                        {
                            Toast.makeText(Registration.this,"data inserted",Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(Registration.this,"error",Toast.LENGTH_LONG).show();
                        }




                    }
                }
        );
    }


}
