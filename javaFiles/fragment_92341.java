public class Base {
    // Pass monthName param as "August"
    public int getMonthNumber(String monthName) throws ParseException {
        Date date = new SimpleDateFormat("MMMM").parse(monthName);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        return calendar.get(Calendar.MONTH) + 1;
    }

    // Pass date param as "Sun, Jul 1"
    public String getMonthNameInThreeChars(String date) {
        return date.substring(5, 8);
    }
}


public class CommonLocators extends Base {

public void setAndroidDatePicker(String date) throws IOException, ParseException {
        int thisYear = Integer.valueOf(androidDriver.findElement(By.id("android:id/date_picker_header_year")).getAttribute("name"));
        String today = androidDriver.findElement(By.id("android:id/date_picker_header_date")).getAttribute("name");
        int thisMonth = getMonthNumber(getMonthNameInThreeChars(today));

        // Split the given date into date, month and year
        String[] splitdate = date.split("\\s+");

        int givenDay = Integer.valueOf(splitdate[0]);
        int givenMonth = getMonthNumber(splitdate[1]);
        int givenYear = Integer.valueOf(splitdate[2]);

        int forwardTaps = 0;
        int backwardTaps = 0;
        int yearFactor = 0;

            if (givenYear == thisYear)
            {
                if (givenMonth >= thisMonth)
                {
                    forwardTaps = givenMonth - thisMonth;
                } else {
                    backwardTaps = thisMonth - givenMonth;
                }
            }
                else if (givenYear > thisYear)
                {
                    yearFactor = (givenYear - thisYear) * 12;
                        if (givenMonth >= thisMonth)
                        {
                            forwardTaps = yearFactor + (givenMonth - thisMonth);
                        } else {
                            forwardTaps = yearFactor - (thisMonth - givenMonth);
                        }
                }
                    else {
                        yearFactor = (thisYear - givenYear) * 12;
                            if (givenMonth >= thisMonth)
                            {
                                backwardTaps = yearFactor - (givenMonth - thisMonth);
                            } else {
                                backwardTaps = yearFactor + (thisMonth - givenMonth);
                            }
                    }


        for (int i=1; i<=forwardTaps; i++) {
            androidDriver.findElement(By.id("android:id/next")).click();
        }

        for (int i=1; i<=backwardTaps; i++) {
            androidDriver.findElement(By.id("android:id/prev")).click();
        }

        String xpath = "//android.view.View[@text='day']";
        androidDriver.findElement(By.xpath(xpath.replace("day", String.valueOf(givenDay)))).click();
        //Tap on OK button of the date picker
        androidDriver.findElement(By.id("android:id/button1")).click();

    }
}


public class CommonStepDefinitions {

    @Test
    public void setDate(String date) throws IOException, ParseException {
        commonLocators.setAndroidDatePicker(date);
    }
}