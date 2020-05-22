SimpleDateFormat simpleDateFormatMonthDayYear = new SimpleDateFormat("M/d/yyyy");
try {
    Date date = simpleDateFormatMonthDayYear.parse(field.getText());

    if (date != null) {

        String formatted = simpleDateFormatMonthDayYear.format(date);
        if (!formatted.equals(field.getText())) {

            System.out.println("Date is not valid");

        }

    } else {

        System.out.println("Error! Please enter a valid start date in the format M/d/yyyy (e.g. 1/2/2015)!");

    }
} catch (ParseException exp) {

    System.out.println("Error! Please enter a valid start date in the format M/d/yyyy (e.g. 1/2/2015)!");

}