package com.Weal.sachin.omcom;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sachin on 2/2/2017.
 */

public class TImePickerEndTime extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        // Get a Calendar instance
        final Calendar calendar = Calendar.getInstance();
        // Get the current hour and minute
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);


        // TimePickerDialog Theme : THEME_DEVICE_DEFAULT_LIGHT
        TimePickerDialog tpd = new TimePickerDialog(getActivity(),
                AlertDialog.THEME_DEVICE_DEFAULT_LIGHT,this,hour,minute,false);

        // TimePickerDialog Theme : THEME_DEVICE_DEFAULT_DARK
        TimePickerDialog tpd2 = new TimePickerDialog(getActivity(),
                AlertDialog.THEME_DEVICE_DEFAULT_DARK,this,hour,minute,false);

        // TimePickerDialog Theme : THEME_HOLO_DARK
        TimePickerDialog tpd3 = new TimePickerDialog(getActivity(),
                AlertDialog.THEME_HOLO_DARK,this,hour,minute,false);

        // TimePickerDialog Theme : THEME_HOLO_LIGHT
        TimePickerDialog tpd4 = new TimePickerDialog(getActivity(),
                AlertDialog.THEME_HOLO_LIGHT,this,hour,minute,false);

        // TimePickerDialog Theme : THEME_TRADITIONAL
        TimePickerDialog tpd5 = new TimePickerDialog(getActivity(),
                AlertDialog.THEME_TRADITIONAL,this,hour,minute,false);

        // Return the TimePickerDialog
        return tpd;
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute){

        String am_pm = "";
        String tm = new SimpleDateFormat("HH:mm").format(new Date(hourOfDay));
        Calendar datetime1 = Calendar.getInstance();
        datetime1.set(Calendar.HOUR_OF_DAY, hourOfDay);
        datetime1.set(Calendar.MINUTE, minute);

        String strDate = tm.format(String.valueOf(datetime1.getTime()));


        if (datetime1.get(Calendar.AM_PM) == Calendar.AM)
            am_pm = "AM";
        else if (datetime1.get(Calendar.AM_PM) == Calendar.PM)
            am_pm = "PM";

        String strHrsToShow1 = (datetime1.get(Calendar.HOUR) == 00)?"12":datetime1.get(Calendar.HOUR)+"";
      //  ((EditText)getActivity().findViewById(R.id.End_time)).setText(String.format("%02d:%02d", strHrsToShow1, datetime1.get(Calendar.MINUTE) + "") +" "+am_pm);
    //   ((EditText)getActivity().findViewById(R.id.End_time)).setText(String.format("%02d:%02d", strHrsToShow1, datetime1.get(Calendar.MINUTE)));
        /*((EditText)getActivity().findViewById(R.id.End_time)
        ).setText( String.format("%02d:%02d", strHrsToShow1, datetime1.get(Calendar.MINUTE) + "") +" "+am_pm);
*/

        int hour = hourOfDay % 12;
        ((EditText) getActivity().findViewById(R.id.End_time)).setText(String.format("%02d:%02d %s", hour == 0 ? 12 : hour,
                minute, hourOfDay < 12 ? "am" : "pm"));

    }
}