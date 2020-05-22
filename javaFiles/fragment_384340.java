@Temporal(TemporalType.TIMESTAMP)
@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
public Date getStartDate() {
    return startDate;
}
public void setStartDate(Date startDate) {
    this.startDate = startDate;
}