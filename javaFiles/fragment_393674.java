String common="Tue, 27 Mar 2012 "; //09:11:37 GMT
            String time1="1:50:10";
            String time2="3:30:20";
             long startTime = HttpDateParser.parse(common+time1+" GMT");
             System.out.println("start time is :" + startTime);
             long endTime =  HttpDateParser.parse(common+time2+" GMT");
             System.out.println("end time is :" + endTime);
             long diff = endTime - startTime;
            long hours=diff/(60*60*1000);
         long minutes=(diff%(60*60*1000))/(60*1000);

         long sec=((diff%(60*60*1000))%(60*1000))/1000;
         String formateddate="";
         if(hours<10)
         {
             formateddate="0"+hours;
         }else{
             formateddate=""+hours;
         }
         if(minutes<10)
         {
             formateddate=formateddate+":0"+minutes;
         }else{
             formateddate=formateddate+":"+minutes;
         }
         if(sec<10)
         {
             formateddate=formateddate+":0"+sec;
         }else{
             formateddate=formateddate+":"+sec;
         }


         System.out.println("Difference in Houres:"+formateddate);