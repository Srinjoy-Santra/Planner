package com.example.newu.planner;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyDBHandler dbHandler;
    TextView textView;
    EditText editText;
    ListView listView;
    static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.mainNewTodo);

        dbHandler = new MyDBHandler(this);
        printData();
    }



    public void addButtonClicked(View view) {


        String edstr = editText.getText().toString();
        TaskType taskType = new TaskType();
        taskType.setTaskname(edstr);

        long g = dbHandler.addTask(taskType);
       if (g > 0)
            Toast.makeText(getApplicationContext(), "Processing done!" + edstr, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(getApplicationContext(), "Registration incomplete!", Toast.LENGTH_SHORT).show();

        printData();

    }

    public void deleteButtonClicked(View view) {
       // CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);

        //TextView textView2= (TextView) findViewById(R.id.textView);
       //if (checkBox.isChecked())
       {
            dbHandler.deleteTask(textView.toString());
            //arrayList.remove(textView.toString());
        }
        //printDatabase();
       printData();
    }


    public void printData() {

        Cursor cursor = dbHandler.selectData();

        int f = cursor.getCount(), i = 0;

        String stres[] = new String[f];

        //Toast.makeText(getApplicationContext(), "rows" + f, Toast.LENGTH_SHORT).show();

        while (cursor.moveToNext()) {

            stres[i++] = cursor.getString(cursor.getColumnIndex(MyDBHandler.COLUMN_TASKNAME));
        }

        //Toast.makeText(getApplicationContext(), "col" + cursor.getColumnName(count++), Toast.LENGTH_LONG).show();
        //String s[]=cursor.getColumnNames();
        //for(int i=0;i<f;i++) System.out.print(s[i]);
        //Toast.makeText(getApplicationContext(), "length" + cursor.get(), Toast.LENGTH_LONG).show();

        listView = (ListView) findViewById(R.id.todoListView);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), stres);
        listView.setAdapter(customAdapter);
        Toast.makeText(MainActivity.this,"works1", Toast.LENGTH_LONG).show();

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String edstr = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this, edstr, Toast.LENGTH_LONG).show();
                        //String edstr = String.valueOf(parent.getItemAtPosition(position));
                        Intent intent=new Intent(getApplicationContext(),Taskdetails_Activity.class);
                        intent.putExtra("Taskname",edstr);
                        startActivity(intent);
                    }
                }
        );



        editText.setText("");
    }
}

//<activity android:name=".CustomAdapter"></activity>