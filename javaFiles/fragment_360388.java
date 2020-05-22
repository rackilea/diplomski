long lastVistedDateTime = getLastVistedDateTime();
int lastDay = new Date(lastVistedDateTime).getDay();
int today = Calendar.get(Calendar.DATE);
if (today != lastDay){
    //an other day
    setLastVistedDateTime(Calendar.getInstance().getTimeInMillis());
}