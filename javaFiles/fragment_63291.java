DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");       
     Date date = dateFormat.parse("2013-09-23 17:57:19.860");
     long time = date.getTime();
     Timestamp timestamp =new Timestamp(time);      
     SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
     String result = dateFormat.format(new Date(timestamp.getTime() ));