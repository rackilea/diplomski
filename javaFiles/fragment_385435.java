String fromDate = "5-April-10";

formatter = new SimpleDateFormat("dd-MMMM-yy");
convertedDate = (Date) formatter.parse(fromDate);

System.out.println("Converted Date: " +convertedDate);