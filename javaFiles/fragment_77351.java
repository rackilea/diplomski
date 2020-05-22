SimpleDateFormat rawDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
DateTime logTime;
for (String logfileLine : logfileLines) {
    logTime = rawDateFormat.parse(stringDateFromLine);
    if (logTime > myPeriodStart && logTime < myPeriodEnd) {
        writeToOutputFile(logfileLine);
    }
}