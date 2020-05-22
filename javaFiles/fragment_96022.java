int offset = cal.get(Calendar.ZONE_OFFSET) + cal.get(Calendar.DST_OFFSET);
// If there is no offset, we have "Coordinated
// Universal Time."
if (offset == 0)
    buff.append('Z');
 else {
    // Convert milliseconds to hours and minutes
     int hrs = offset/(60*60*1000);
     // In a few cases, the time zone may be +/-hh:30.
      int min = offset%(60*60*1000);
      char posneg = hrs < 0? '-': '+';
      buff.append(posneg + formatDigits(hrs) + ':' + formatDigits(min));
  }