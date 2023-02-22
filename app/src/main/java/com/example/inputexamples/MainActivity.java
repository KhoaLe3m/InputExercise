package com.example.inputexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText FullName;
    EditText Phone;
    Switch Gender;
    Spinner spinner;
    SeekBar Age;
    CheckBox football;
    CheckBox volleyball;
    RadioGroup Music;
    RadioButton Rap;
    RadioButton Ballap;
    RadioButton Rock;

    Button Submit;
    Button Reset;

    String TrinhDo;
    ArrayList<String> list;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> arrayTrinhDo = new ArrayList<String>();
        arrayTrinhDo.add("Cao Đẳng");
        arrayTrinhDo.add("Đại Học");
        arrayTrinhDo.add("Chưa Học");

        FullName = findViewById(R.id.fullName);
        Phone = findViewById(R.id.Phone);
        Gender = findViewById(R.id.gender);
        spinner = findViewById(R.id.trinhdo);
        Age = findViewById(R.id.Tuoi);
        football = findViewById(R.id.football);
        volleyball = findViewById(R.id.volleyball);
        Music = findViewById(R.id.Music);
        Rock =findViewById(R.id.Rock);
        Rap =findViewById(R.id.Rap);
        Ballap =findViewById(R.id.Ballap);
        Submit = findViewById(R.id.submit);
        Reset =findViewById(R.id.Reset);

        ArrayAdapter<String> spinnnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,arrayTrinhDo);
        spinnnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(spinnnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TrinhDo = arrayTrinhDo.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                TrinhDo = arrayTrinhDo.get(0);
            }
        });


         View.OnClickListener Register = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = FullName.getText().toString();
                int sdt = Integer.valueOf(Phone.getText().toString());
                boolean gioitinh = Gender.isChecked();
                int tuoi = Integer.valueOf(Age.getProgress());
                String sport = "";
                if(football.isChecked()){
                    sport += football.getText() +"\t";
                }else if(volleyball.isChecked()){
                    sport += volleyball.getText() +"\t";
                }
                String music =radiobtnCheck();
                String gender = checkGender();

                String s = String.format("Person{Name:%s,,Age:%d,Phone:%d,Gender:%s,Knowledge:%s,Sports:%s,Music:%s }",
                        name,tuoi,sdt,gender,
                        TrinhDo,sport,music);
                Intent intent = new Intent(MainActivity.this,ShowPerson.class);
                intent.putExtra("list",s);
                startActivity(intent);
            }
        };
        Submit.setOnClickListener(Register);
        View.OnClickListener Clear = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FullName.setText("");
                Phone.setText(null);
                Gender.setChecked(false);
                TrinhDo = arrayTrinhDo.get(0);
                Age.setProgress(0);
                football.setChecked(false);
                volleyball.setChecked(false);
                Rock.setChecked(false);
                Rap.setChecked(false);
                Ballap.setChecked(false);

            }
        };
        Reset.setOnClickListener(Clear);
    }
    private String radiobtnCheck(){
        String music ="";
        if(Rock.isChecked()){
            music = Rock.getText().toString();
        }else if(Rap.isChecked()){
            music = Rap.getText().toString();
        }else{
            music = Ballap.getText().toString();
        }
        return music;
    }
    private String checkGender(){
        if(Gender.isChecked()){
             return "Male";
        }
        return "Female";
    }


}