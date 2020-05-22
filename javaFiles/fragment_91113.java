public String getName(String project, String user) {

    DateFormat df = new SimpleDateFormat("MM_dd_yyyy_hh_mm");

    return project + "_" + user + "_" + df.format(new Date());
}