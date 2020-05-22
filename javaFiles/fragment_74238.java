LocalDate dt = new LocalDate(2014, 1, 1); // 1st january

for(loop 12 months){

  now loop again to find 3rd wednesday
   while(count < 4) {
        d = d.plusDays(1);
        if(d.getDayOfWeek() != DateTimeConstants.WEDNESDAY){
          count++
        }
      // now based on count save in hashmap, 1 = 1st, 3 = 3rd for each month

    }
d.plusMonth(1);
}