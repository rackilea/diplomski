sb.append(String.Format("[%1$-10s %2$-10s %3$-10s]: %4",
    new Data(record.getMillis(),
    record.getSourceMethodName(),
    record.getSourceClassName(),
    formatMessage(record)
));