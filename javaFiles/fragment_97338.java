Calendar ci = Calendar.getInstance();
     String AM_PM;

      if(ci.get(Calendar.AM_PM)==0)
        {
             AM_PM ="AM";
        }
        else
        {
             AM_PM ="PM";
        }
        String CiDateTime = "" + ci.get(Calendar.YEAR) + "-" + 
            (ci.get(Calendar.MONTH) + 1) + "-" +
            ci.get(Calendar.DAY_OF_MONTH)+" "+AM_PM;

         System.out.println("time=========================================="+CiDateTime);