SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
try {
    Date date = new Date(sdf.parse(strDate).getTime());
} catch (ParseException e) {
    e.printStackTrace();
}