package com.evil.example.visaworld;

        import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.SQLException;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteException;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.ButtonBarLayout;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RelativeLayout;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;


        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.OutputStream;
        import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Spinner s1, s2;
    ArrayAdapter<CharSequence> a1;
    public String f1, f2;
    public int i1,i2;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DataBaseHelper myDbHelper;
        myDbHelper = new DataBaseHelper(this);

        s1 = (Spinner) findViewById(R.id.spinner1);
        s2 = (Spinner) findViewById(R.id.spinner2);
        b1 = (Button)findViewById(R.id.button);
        a1 = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
        a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(a1);
        s2.setAdapter(a1);
        try {

            myDbHelper.createDataBase();

        } catch (IOException ioe) {

            throw new Error("Unable to create database");

        }

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selected ", Toast.LENGTH_LONG).show();
                }
                f1 = (String) parent.getItemAtPosition(position);

                i1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selected", Toast.LENGTH_LONG).show();
                }
                f2 = (String) parent.getItemAtPosition(position);

                i2 = position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

            b1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    if(i1!=0 && i2!=0) {
                        if(i1==i2)
                        {
                            Toast.makeText(getBaseContext(),"select two different countries",Toast.LENGTH_LONG).show();
                        }
                        else {

                            switch (f2) {
                                case "AFGHANISTAN":
                                    Intent myIntent0 = new Intent(MainActivity.this, AFGHANISTAN.class);
                                    startActivity(myIntent0);
                                    break;
                                case "ARGENTINA":
                                    Intent myIntent1 = new Intent(MainActivity.this, ARGENTINA.class);
                                    startActivity(myIntent1);
                                    break;
                                case "AUSTRALIA":
                                    Intent myIntent2 = new Intent(MainActivity.this, AUSTRALIA.class);
                                    startActivity(myIntent2);
                                    break;
                                case "BANGLADESH":
                                    Intent myIntent3 = new Intent(MainActivity.this, BANGLADESH.class);
                                    startActivity(myIntent3);
                                    break;
                                case "BRAZIL":
                                    Intent myIntent4 = new Intent(MainActivity.this, BRAZIL.class);
                                    startActivity(myIntent4);
                                    break;
                                case "CHINA":
                                    Intent myIntent5 = new Intent(MainActivity.this, CHINA.class);
                                    startActivity(myIntent5);
                                    break;
                                case "COLOUMBIA":
                                    Intent myIntent6 = new Intent(MainActivity.this, COLOUMBIA.class);
                                    startActivity(myIntent6);
                                    break;
                                case "FRANCE":
                                    Intent myIntent7 = new Intent(MainActivity.this, FRANCE.class);
                                    startActivity(myIntent7);
                                    break;
                                case "GERMANY":
                                    Intent myIntent8 = new Intent(MainActivity.this, GERMANY.class);
                                    startActivity(myIntent8);
                                    break;
                                case "INDIA":
                                    Intent myIntent9 = new Intent(MainActivity.this, INDIA.class);
                                    startActivity(myIntent9);
                                    break;
                                case "INDONESIA":
                                    Intent myIntent10 = new Intent(MainActivity.this, INDONESIA.class);
                                    startActivity(myIntent10);
                                    break;
                                case "ITALY":
                                    Intent myIntent11 = new Intent(MainActivity.this, ITALY.class);
                                    startActivity(myIntent11);
                                    break;
                                case "JAPAN":
                                    Intent myIntent12 = new Intent(MainActivity.this, JAPAN.class);
                                    startActivity(myIntent12);
                                    break;
                                case "MALAYSIA":
                                    Intent myIntent13 = new Intent(MainActivity.this, MALAYSIA.class);
                                    startActivity(myIntent13);
                                    break;
                                case "NEWZEALAND":
                                    Intent myIntent14 = new Intent(MainActivity.this, NEWZEALAND.class);
                                    startActivity(myIntent14);
                                    break;
                                case "QATAR":
                                    Intent myIntent15 = new Intent(MainActivity.this, QATAR.class);
                                    startActivity(myIntent15);
                                    break;
                                case "RUSSIA":
                                    Intent myIntent16 = new Intent(MainActivity.this, RUSSIA.class);
                                    startActivity(myIntent16);
                                    break;
                                case "SAUDI ARABIA":
                                    Intent myIntent17 = new Intent(MainActivity.this, SAUDIARABIA.class);
                                    startActivity(myIntent17);
                                    break;
                                case "SINGAPORE":
                                    Intent myIntent18 = new Intent(MainActivity.this, SINGAPORE.class);
                                    startActivity(myIntent18);
                                    break;
                                case "SOUTH AFRICA":
                                    Intent myIntent19 = new Intent(MainActivity.this, SOUTHAFRICA.class);
                                    startActivity(myIntent19);
                                    break;
                                case "SPAIN":
                                    Intent myIntent20 = new Intent(MainActivity.this, SPAIN.class);
                                    startActivity(myIntent20);
                                    break;
                                case "SWEDEN":
                                    Intent myIntent21 = new Intent(MainActivity.this, SWEDEN.class);
                                    startActivity(myIntent21);
                                    break;
                                case "THAILAND":
                                    Intent myIntent22 = new Intent(MainActivity.this, THAILAND.class);
                                    startActivity(myIntent22);
                                    break;
                                case "UAE":
                                    Intent myIntent23 = new Intent(MainActivity.this, UAE.class);
                                    startActivity(myIntent23);
                                    break;
                                case "UK":
                                    Intent myIntent24 = new Intent(MainActivity.this, UK.class);
                                    startActivity(myIntent24);
                                    break;
                                case "USA":
                                    Intent myIntent25 = new Intent(MainActivity.this, USA.class);
                                    startActivity(myIntent25);
                                    break;
                            }

                            try {

                                myDbHelper.openDataBase(f1, f2);

                            } catch (SQLException sqle) {

                                throw sqle;
                            }
                        }
                    }
                    else
                    {
                        Toast.makeText(getBaseContext(),"please select country",Toast.LENGTH_SHORT).show();
                    }

                }
            });








    }
}

