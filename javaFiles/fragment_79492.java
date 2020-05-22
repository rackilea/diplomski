> You should try this one for getting current date:




 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                    String todate= dateFormat.format(currentdate());

  String  finalto = todate.toString(); //here you get current date
    private Date currentdate() {
            final Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 0);
            return cal.getTime();
        }