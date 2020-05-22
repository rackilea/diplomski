// start service
String[] script = {"cmd.exe", "/c", "sc", "start", SERVICE_NAME};

// stop service
String[] script = {"cmd.exe", "/c", "sc", "stop", SERVICE_NAME};

// check whether service is running or not
String[] script = {"cmd.exe", "/c", "sc", "query", APP_SERVICE_NAME, "|", "find", "/C", "\"RUNNING\""};