for (LogEntry entry : driver.manage().logs().get(LogType.PERFORMANCE)) {
        if(entry.getMessage().contains("Network.dataReceived")) {
            Matcher dataLengthMatcher = Pattern.compile("encodedDataLength\":(.*?),").matcher(entry.getMessage());
            dataLengthMatcher.find();
            //Do whatever you want with the data here.
        }