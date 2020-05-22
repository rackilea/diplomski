Function<String[],MonitoredData> factory = data->{
   DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   try{
     return new MonitoredData(format.parse(data[0]),format.parse(data[1]),data[2]);
     //                       ^--startingTime       ^--finishingTime      ^--label
   }catch(ParseException ex){
     throw new IllegalArgumentException(ex);
   }
};