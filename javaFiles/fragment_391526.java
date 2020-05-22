public int getSeconds(String timeValue){

String[] splitByColon = timeValue.split(":"); 
int hoursValue = Integer.parseInt(splitByColon[0])); 

String[] splitForMins = splitByColon[1].split(" "); 

if(splitForMins[1].equals("PM"))
{
hoursValue = hoursValue + 12; 
}

int minutesValue = Integer.parseInt(splitForMins[0]); 

return 3600*hoursValue + 60*minutesValue; 

}