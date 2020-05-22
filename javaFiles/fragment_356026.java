Date getDateFrmString(String dDate)
  {       

    java.sql.Date dDate  = new java.sql.Date(new SimpleDateFormat("yyyy-MM-dd").parse(sDate).getTime());
    return dDate;
  }