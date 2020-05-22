Calendar c = Calendar.getInstance();
int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

if(timeOfDay >= 0 && timeOfDay < 12){
    Toast.makeText(this, "Good Morning", Toast.LENGTH_SHORT).show();        
}else if(timeOfDay >= 12 && timeOfDay < 16){
    Toast.makeText(this, "Good Afternoon", Toast.LENGTH_SHORT).show();
}else if(timeOfDay >= 16 && timeOfDay < 21){
    Toast.makeText(this, "Good Evening", Toast.LENGTH_SHORT).show();
}else if(timeOfDay >= 21 && timeOfDay < 24){
    Toast.makeText(this, "Good Night", Toast.LENGTH_SHORT).show();
}