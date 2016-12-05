package com.example.samsung.calender;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by samsung on 2016-12-04.
 */

public class LookActivity extends AppCompatActivity{

    public void onCreate(Bundle savedInstateState){
        super.onCreate(savedInstateState);
        setContentView(R.layout.activity_look);
        setTitle("일정 상세보기");

        Button editM = (Button) findViewById(R.id.edit_button);
        Button deleteM = (Button) findViewById(R.id.delete_button);

    }
}
