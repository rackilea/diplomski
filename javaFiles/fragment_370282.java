private Date startDate, endDate;

public void setDates(Date startDate, Date endDate) {
    Date startCopy = new Date(startDate);
    Date endCopy = new Date(endDate);
    if ( startCopy.after(endCopy) ) {
        throw new IllegalArgumentException("start must not be after end");
    }

    this.startDate = startCopy;
    this.endDate = endCopy;
 }