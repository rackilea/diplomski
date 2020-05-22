else if(date_holder.equals("today"))
           {
               DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
               Calendar cal = Calendar.getInstance();
               System.out.println(dateFormat.format(cal.getTime()));
           }