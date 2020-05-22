private static final String DUMPSYSCOMMAND = "dumpsys package com.PACKAGENAME.service | grep versionName";

String versionString = runADBCommand({"adb", "-s", deviceIP, "shell", DUMPSYSCOMMAND});

...

public String runADBCommand(String[] adbCommand) throws IOException {

...

// do not forget to remove / modify this println - it expect a string
//        System.out.println("adbCommand = " + adbCommand);