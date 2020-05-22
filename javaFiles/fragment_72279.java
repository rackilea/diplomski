SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
         df.setLenient(false); //note the change here
            try {
                Date result =  df.parse("2009-02-40");
                System.out.println(result);
            } catch (ParseException e) {
                e.printStackTrace();
            }