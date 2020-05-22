Integer y = itapi.getPlayerYears(player.getName());
double yremove = Integer.valueOf(y) *0.25;
double numWeeks = yremove * 52; //returns the number in weeks
double numDays =0;
double numHours =0;
double numMinutes =0;
double numSeconds =0;
if(numWeeks % 52 != 0){
    numDays = (numWeeks % 52) * 7;
    if(numDays % 7 !=0){
          numHours = (numDays % 7) * 24;
          if(numHours % 24 !=0){
              numMinutes = (numHours % 24) * 60;
              if(numMinutes % 60 !=0){
                   numSeconds = (numMinutes % 60) * 60;
              }
          }
    }
}
//... then convert to string as you are already doing and pass it to removeTime()