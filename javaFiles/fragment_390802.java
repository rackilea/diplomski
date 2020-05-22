public String getBdate() { 
    if (dob != null) {
        bdate = new SimpleDateFormat(DATE_FORMAT).format(dob);
    }

    return bdate;
}