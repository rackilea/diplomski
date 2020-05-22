public class PrintProcessor {
    ...
    public String getPrintJobName(Shipper shipper) {
        String printJobName = null;
        String timeHash = this.getTimeHash();
        if (this.isBeforeFourPM()) {
            switch(shipper) {
                printJobName = // Do something with timeHash to generate name
            }
        } else {
            ...
        }
        return printJobName;
    }

    public boolean isBeforeFourPM() {
        return (jodaTime.getCurrentDateTimeEST().isBefore(jodaTime.getFourPM_EST()) ||
            jodaTime.getCurrentDateTimeEST().isAfter(jodaTime.getSevenPM_EST()));
    }

    public String getTimeHash() {
        ... // Do something to hash the time value in to a String
    }
}