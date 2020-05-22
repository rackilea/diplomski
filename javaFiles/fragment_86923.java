Logs logs = driver.manage().logs();
LogEntries logEntries = logs.get(LogType.DRIVER);

for (LogEntry logEntry : logEntries) {
    System.out.println(logEntry.getMessage());
}