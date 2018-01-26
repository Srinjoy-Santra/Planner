package layout;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.CalendarView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.Calendar;


public class dateInput extends PopupWindow implements CalendarView.OnDateChangeListener
{
 CalendarView calendarView;
 TextView datechosen;

    public void setCalendarView(CalendarView calendarView) {
        this.calendarView = calendarView;
    }

    public dateInput(View v, int w, int h) {
     super(v, w, h);
     calendarView.setDate(Calendar.getInstance().getTimeInMillis(), false, true);
 }


    @Override
    public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
        //Toast.makeText(calendarView,"i2+"/"+i1+"/"+i", Toast.LENGTH_SHORT).show();
        datechosen.setText(i2+"/"+i1+"/"+i);

    }
}