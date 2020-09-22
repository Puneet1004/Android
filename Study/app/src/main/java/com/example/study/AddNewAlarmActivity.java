package com.example.study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewAlarmActivity extends AppCompatActivity {
    private static final String TAG = "AddNewAlarmActivity";

    private EditText edtTxtHour,edtTxtMinute;
    private Button btnAddAlarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_alarm);

        btnAddAlarm = (Button) findViewById(R.id.btnAddAlarm);
        edtTxtHour = (EditText) findViewById(R.id.edtTxtHour);
        edtTxtMinute = (EditText) findViewById(R.id.edtTxtMinute);

        btnAddAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewAlarm();
            }
        });

    }

    private void addNewAlarm(){
        Log.d(TAG, "addNewAlarm: started");
        int hours = Integer.valueOf(edtTxtHour.getText().toString());
        int minutes = Integer.valueOf(edtTxtMinute.getText().toString());

        Bundle bundle = new Bundle();
        bundle.putInt("hours", hours);
        bundle.putInt("minutes",minutes);

        Intent intent = new Intent(AddNewAlarmActivity.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(getString(R.string.bundle), bundle);
        startActivity(intent);


    }
}
