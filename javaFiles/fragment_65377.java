@Value("${screenshot.path}")
private String screenshotPath;
...
new File(screenshotPath.replace("${timestamp}", System.currentTimeMillis());

//or the following without the need for ${timestamp} in screenshot.path
//new File(screenshotPath + System.currentTimeMillis());