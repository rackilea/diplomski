// Convert milliseconds to hours and minutes
  int hrs = offset/(60*60*1000);
  // In a few cases, the time zone may be +/-hh:30.
  //get the remaining offset in ms
  offset -= (hrs*60*60*1000);
  //convert remaining offset into minutes
  int min = offset/(60*1000);
  char posneg = hrs < 0? '-': '+';
  buff.append(posneg + formatDigits(hrs) + ':' + formatDigits(min));