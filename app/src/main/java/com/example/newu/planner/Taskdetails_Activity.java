package com.example.newu.planner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import layout.dateInput;

public class Taskdetails_Activity extends AppCompatActivity {
    EditText et1, et2,et3;
    String taskname;
    MyDBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task__details);

        Intent intent = getIntent();

        taskname = intent.getStringExtra("Taskname");
        //MyDBHandler ref=intent.getSerializableExtra("Reference");

        TextView textView = (TextView) findViewById(R.id.textViewName);
        textView.setText(taskname);

        et1 = (EditText) findViewById(R.id.editTextSubtask);
        et2 = (EditText) findViewById(R.id.editTextNote);
        et3 = (EditText) findViewById(R.id.editTextReminder);


        /*
        TaskType taskType = new TaskType(taskname,et1.toString(),et2.toString(),et3.toString());
        MyDBHandler dbHandler = new MyDBHandler(this,null,null,1);
        dbHandler.updateTask(et1.toString(),et2.toString(),et3.toString(),taskname);

        String tim=et3.getText().toString();
        long hr=Long.parseLong(tim.substring(0,1));
        long min=Long.parseLong(tim.substring(3,4));

        long t= hr*60*60+ min*60;

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent1 = new Intent(getApplicationContext(),BackgroundProcess.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),11,intent1,0);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+t*1000,pendingIntent);

        //long g =ref.addTask(taskType);*/


    }



    public void addDetails(View view) {
        dbHandler = new MyDBHandler(getApplicationContext());
        int a=dbHandler.updateTask(et1.getText().toString(),
                et2.getText().toString(),
                et3.getText().toString(), taskname);
    if (a>0){
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
    }
    else {
        Toast.makeText(this, "Not added", Toast.LENGTH_SHORT).show();
    }
    }

    public void deleteButtonClicked(View view) {
        dbHandler= new MyDBHandler(getApplicationContext());
        int a=dbHandler.deleteTask(taskname);
        if (a>0){
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Not deleted", Toast.LENGTH_SHORT).show();
        }
    }

    public void dateclicked(View view) {
        LayoutInflater layoutInflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1= layoutInflater.inflate(R.layout.time_date_popup,null);
        PopupWindow popupWindow=new dateInput(view1, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        EditText editText= (EditText) findViewById(R.id.editTextReminder);
        editText.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                      }
                                  }
        );
        popupWindow.showAtLocation(view, Gravity.CENTER,0,0);
    }
}
