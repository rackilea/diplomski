String pattern = "yyyy-MM-dd HH:mm";
SimpleDateFormat formatter = new SimpleDateFormat(pattern);
String lastTime = "";
long lastDate = 0;
while ((strLine = br.readLine()) != null) {
    String myDateString = strLine.split(", ")[0];
    if (!myDateString.startsWith(lastTime)) {
        lastTime = myDateString.substring(0, pattern.length());
        lastDate = formatter.parse(lastTime).getTime();
    }
    Date date = new Date(lastDate + Integer.parseInt(myDateString.substring(pattern.length() + 1).replace(":", "")));
}