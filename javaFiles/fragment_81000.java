String dateString  = "09/05/2017";
        try {
            Date  date1  = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
            String day  = new SimpleDateFormat("EEEE").format(date1);
            System.out.print(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }