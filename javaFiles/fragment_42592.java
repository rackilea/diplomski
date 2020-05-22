btnOpen.setOnClickListener(new InnerOnClickListener());

...

private class InnerOnClickListener implements OnClickListener
{
     public void onClick(View v) 
     { 
         Toast.makeText(getBaseContext(), 
                        "Time selected:" +  
                        timePicker.getCurrentHour() +  
                        ":" + timePicker.getCurrentMinute(), 
                        Toast.LENGTH_SHORT).show(); 
     } 
}