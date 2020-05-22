import java.util.Calendar;

import net.rim.device.api.i18n.SimpleDateFormat;
import net.rim.device.api.io.http.HttpDateParser;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.picker.DateTimePicker;

public final class Screen1 extends MainScreen implements FieldChangeListener
{
    /**
     * Creates a new MyScreen object
     */
    ButtonField date1;
    ButtonField date2;
    ButtonField button;
    LabelField lbl;
    DateTimePicker picker;
    String str="";
    Calendar cal;   

    public Screen1()
    {   

        date1=new ButtonField("date1");
        date1.setChangeListener(this);
        add(date1);

        date2=new ButtonField("date2");
        date2.setChangeListener(this);
        add(date2);

        button = new ButtonField("Screen 1 ");
        button.setChangeListener(this);
        add(button);
        lbl=new LabelField();
        add(lbl);
    }
    public void fieldChanged(Field field, int context) {
        if(field==button){//Tue, 27 Mar 2012 09:11:37 GMT

            System.out.println(date1.getLabel().toString()+"   "+date2.getLabel().toString());
             long startTime = HttpDateParser.parse(date1.getLabel().toString());
             System.out.println("start time is :" + startTime);
             long endTime =  HttpDateParser.parse(date2.getLabel().toString());
             System.out.println("end time is :" + endTime);
             long diff = endTime - startTime;

             long hours=diff/(60*60*1000);
         long minutes=(diff%(60*60*1000))/(60*1000);

         long sec=((diff%(60*60*1000))%(60*1000))/1000;
         String formateddate="";
         if(hours<10)
         {
             formateddate="0"+hours;
         }else{
             formateddate=""+hours;
         }
         if(minutes<10)
         {
             formateddate=formateddate+":0"+minutes;
         }else{
             formateddate=formateddate+":"+minutes;
         }
         if(sec<10)
         {
             formateddate=formateddate+":0"+sec;
         }else{
             formateddate=formateddate+":"+sec;
         }


         System.out.println("Difference in Houres:"+formateddate);
         lbl.setText("Time Between above dates is :"+formateddate);
        }else if(field==date1)
        {
            date1.setLabel(getDateTimeFromPicker().toString());                                 

        }else if(field==date2)
        {
            date2.setLabel(getDateTimeFromPicker().toString());
        }

    }
    private String getDateTimeFromPicker()
    {
        picker = DateTimePicker.createInstance( Calendar.getInstance(), "yyyy-MM-dd", "HH:mm:ss");
        picker.doModal();
        cal=picker.getDateTime();
        str="";
        if((cal.get(Calendar.MONTH)+1)<10)
            str=str+cal.get(Calendar.YEAR)+"-"+"0"+(cal.get(Calendar.MONTH)+1);
        else
            str=str+cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1);

        if(cal.get(Calendar.DATE)<10)
            str=str+"-"+"0"+cal.get(Calendar.DATE);
        else
            str=str+"-"+cal.get(Calendar.DATE);

        if(cal.get(Calendar.HOUR_OF_DAY)<10)
            str=str+" "+"0"+cal.get(Calendar.HOUR_OF_DAY);
        else
            str=str+" "+cal.get(Calendar.HOUR_OF_DAY);

        if(cal.get(Calendar.MINUTE)<10)
            str=str+":"+"0"+cal.get(Calendar.MINUTE);
        else
            str=str+":"+cal.get(Calendar.MINUTE);

        if(cal.get(Calendar.SECOND)<10)
            str=str+":"+"0"+cal.get(Calendar.SECOND);
        else
            str=str+":"+cal.get(Calendar.SECOND);
        return str;
    }
}