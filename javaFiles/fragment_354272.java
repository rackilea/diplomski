private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

public String format(LogRecord record) {
    StringBuilder builder = new StringBuilder(1000);
    builder.append(df.format(new Date(record.getMillis()))).append(" - ");
    builder.append("[").append(record.getLevel()).append("] : ");
    builder.append(formatMessage(record));
    builder.append("\n");
    return builder.toString();
}

public String getHead(Handler h) {
    return super.getHead(h);
}

public String getTail(Handler h) {
    return super.getTail(h);
}