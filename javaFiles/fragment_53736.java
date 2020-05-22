String fromDateFormat = "dd/MM/yyyy";
         String fromdate = 15/03/2018; //Take any date

         String CheckFormat = "dd MMM yyyy";//take another format like dd/MMM/yyyy
         String dateStringFrom;

         Date DF = new Date();


          try
          {
             //DateFormatdf = DateFormat.getDateInstance(DateFormat.SHORT);
             DateFormat FromDF = new SimpleDateFormat(fromDateFormat);
             FromDF.setLenient(false);  // this is important!
             Date FromDate = FromDF.parse(fromdate);
             dateStringFrom = new 
             SimpleDateFormat(CheckFormat).format(FromDate);
             DateFormat FromDF1 = new SimpleDateFormat(CheckFormat);
             DF=FromDF1.parse(dateStringFrom);
             System.out.println(dateStringFrom);
          }
          catch(Exception ex)
          {

              System.out.println("Date error");

          }