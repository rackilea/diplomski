if (this.subject != null && !this.subject.isEmpty()) {
    DateFormat userDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    DateFormat outDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    Date df = userDateFormat.parsethis.subject );
    return outDateFormat.format(df);
}