String input = "[January 1, 2014 3:57 AM] (EmailDeliveryOptionsHome.getAddEmailDeliveryOptions [Connection at : MayConnectionPool]) : Exception Encountered | (java.sql.SQLException: ORA-12899: value too large for column \"BGADMIN\".\"TBLSTOPRINT_ACCT\".\"EMAIL_ADDR\"";
    Pattern p = Pattern.compile("\\[Connection at\\s*:\\s*([^\\]]+)");
    Matcher m  =p.matcher(input);
    if(m.find())
    {
        System.out.println(m.group(1));
    }