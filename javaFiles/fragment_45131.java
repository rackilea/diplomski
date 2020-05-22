Calendar current_time = Calendar.getInstance ();
current_time.add(Calendar.YEAR, 0);
current_time.add(Calendar.DAY_OF_YEAR, 0);
current_time.set(Calendar.HOUR_OF_DAY, 
//Subtract 2 hours       
current_time.get(Calendar.HOUR_OF_DAY)-2);
current_time.set(Calendar.MINUTE, 0);
current_time.set(Calendar.SECOND, 0);

Calendar given_time = Calendar.getInstance ();
given_time.set(Calendar.YEAR, syear);
//Give the day sDay and hour shour
given_time.set(Calendar.DAY_OF_YEAR, sday);
given_time.set(Calendar.HOUR_OF_DAY, shour);
given_time.set(Calendar.MINUTE, 0 );
given_time.set(Calendar.SECOND, 0);

Date current_calendar = current_time.getTime();
Date given_calendar = given_time.getTime();

System.out.println("Current Calendar "+ current_calendar);
System.out.println("Given Calendar "+ given_calendar);

boolean v = current_calendar.after(given_calendar); 

if(v){

    return true;

}