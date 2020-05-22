long estDateInLong=//whatever gives you past date
long currentTimeinLong=Calendar.getInstance().getTimeInMillis();
long diff=(long)(currentTimeinLong-estDateInLong);
long diffDay=diff/(24*60*60 * 1000);
diff=diff-(diffDay*24*60*60 * 1000); //will give you remaining milli seconds relating to hours,minutes and seconds
long diffHours=diff/(60*60 * 1000);
diff=diff-(diffHours*60*60 * 1000); 
long diffMinutes = diff / (60 * 1000);
diff=diff-(diffMinutes*60*1000);
long diffSeconds = diff / 1000;
diff=diff-(diffSeconds*1000);       
System.out.println(diffDay +"\t"+diffHours+"\t"+diffMinutes+"\t"+diffSeconds);