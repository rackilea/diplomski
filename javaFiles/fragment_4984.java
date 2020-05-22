try {
    this.startTime = dateFormat.parse(startTime);
} catch (ParseException e) {
    e.printStackTrace();
}
try {
    this.endTime =  dateFormat.parse(endTime);
} catch (ParseException e) {
    e.printStackTrace();
}