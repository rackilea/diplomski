String lastDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date(lastVistedDateTime));
String nowDate = DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date());
if (!nowDate.equals(lastDate)){
    //an other day
    setLastVistedDateTime(Calendar.getInstance().getTimeInMillis());
}