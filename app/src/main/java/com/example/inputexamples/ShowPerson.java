package com.example.inputexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShowPerson extends AppCompatActivity {
    TextView Show;
    String data;
    ArrayList<String> listnguoi;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_person);
        Show= findViewById(R.id.danhsach);
        String nguoi = new String();
        listnguoi = new ArrayList<>();

        data = "";
        Bundle bundle = getIntent().getExtras();
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                nguoi= null;
            } else {
                nguoi= extras.getString("list");
            }
        } else {
            nguoi= (String) savedInstanceState.getSerializable("list");
        }
        listnguoi.add(nguoi);
        for (String per:listnguoi) {
            data += per.toString() + "\n";
        }
        if(data != ""){
            Show.setText(data);
        }
        else{
            Show.setText("Không có");
        }
    }
}