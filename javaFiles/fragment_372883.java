String dateStr = "16.Aug.2012 07:15:00";
        Date datex = null;
        DateFormat formatter = new SimpleDateFormat("dd.MMM.yyyy hh:mm:ss");
        try {
            datex = (Date) formatter.parse(dateStr);
            System.out.println(datex);
            //Log.w("TIME: ", datex.toString());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }