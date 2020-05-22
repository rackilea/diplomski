Date todayDate = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);
        String currDateStr = dateFormat.format(todayDate);
        String returnDateStr = "01/08/2015";
        Date returnDate = null;
        try {
            returnDate = dateFormat.parse(returnDateStr);
            todayDate = dateFormat.parse(currDateStr);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        long diffInDays = (todayDate.getTime() - returnDate.getTime()) / (24 * 60 * 60 * 1000);
        if (diffInDays == 0) {
            System.out.println("Video is due today!");
        }
        else if (diffInDays > 0) {
            System.out.println("Video is overdue :(");
        }
        else {
            System.out.println("Video returned in advance :) ");
        }