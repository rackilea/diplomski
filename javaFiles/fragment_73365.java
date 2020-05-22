Date myCurrentDate = new Date();

    long timeInFirstWeek = (myCurrentDate.getTime() - 345600000 + 3600000) % 604800000;
    Date firstDateOfWeek = new Date(myCurrentDate.getTime() - timeInFirstWeek - 3600000);
    Date lastDateOfWeek = new Date(firstDateOfWeek.getTime() + 604800000 - 1);

    GWT.log(DateTimeFormat.getFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(lastDateOfWeek));
    GWT.log(DateTimeFormat.getFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(firstDateOfWeek));