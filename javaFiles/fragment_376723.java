days = 0;
int[] daysWeWant = new int[daysWanted];
for(int j = 0; j < NUM_DAYS; j++){
    if(bookings[i][j] == null){
       daysWeWant[days] = j;
       days++;
       if(daysWanted == days){
           break;
       }
    }
    else{
        days = 0;
        int[] daysWeWant = new int[daysWanted];
    }
}
if(days== daysWanted ){
    for(int j = 0 ; j< daysWanted; j++){
        int day = daysWeWant [j];
        this.displayCell (i, day , Color.red);
    }
}