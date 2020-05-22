try{
    String dirName = "//sdcard//MyAppName";
    File newFile = new File(dirName);

    if(newFile.exists() && newFile.isDirectory()) {
      println("Directory Exists... All Good");
    } 
    else {
      println("Directory Doesn't Exist... We're Making It");
      newFile.mkdirs();
    }
  }
  catch(Exception e) {
    e.printStacktrace();
  }