package com.example.study;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button btnAddNewAlarm;
    private RecyclerView recyclerView;
    private static ArrayList<Alarm> allAlarms;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new RecyclerViewAdapter();

        if(null==allAlarms){
            allAlarms = new ArrayList<>();
        }

        btnAddNewAlarm = (Button) findViewById(R.id.btnAddNewAlarm);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setAlarms(allAlarms);


        btnAddNewAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddNewAlarmActivity.class);
                startActivity(intent);
            }
        });

        try {
            Intent intent = getIntent();
            Bundle bundle = intent.getBundleExtra(getString(R.string.bundle));
            if(null!=bundle){
                int hours = bundle.getInt("hours",-1);
                int minute = bundle.getInt("minutes",-1);

                if(hours != -1){
                    Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
                    alarmIntent.putExtra(AlarmClock.EXTRA_HOUR,hours);
                    Log.d(TAG, "onCreate: hours = "+ hours);
                    alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES,minute);
                    Log.d(TAG, "onCreate: minutes = "+ minute);
                    alarmIntent.putExtra(AlarmClock.EXTRA_MESSAGE,"Hello from other side");
                    Alarm alarm = new Alarm(hours,minute,"Hello from other side");
                    allAlarms.add(alarm);
                    adapter.setAlarms(allAlarms);
                    startActivity(alarmIntent);

                }

            }
            else {
                Log.d(TAG, "onCreate: bundle is null");
            }
        }
        catch (Exception e){
            Log.d(TAG, "onCreate: something happened");
            e.printStackTrace();
        }

    }
}
