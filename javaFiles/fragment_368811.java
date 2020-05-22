Date toDate = new Date(114, 5, 30);    
    Calendar calendar = Calendar.getInstance();
                Calendar calendarTo = Calendar.getInstance();
                calendar.setTime(toDate);
                calendarTo.setTime(toDate);
                calendarTo.add(Calendar.DATE, 1);

                System.out.println(toDate);//Mon Jun 30 00:00:00 IST 2014
                System.out.println(calendarTo.getTime());//Tue Jul 01 00:00:00 IST 2014