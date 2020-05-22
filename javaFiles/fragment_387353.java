public void run() {
  MyObject localObj = myObj;
  if (localObj != null { //NOTE: myObj may have been released
    localObj.pubFunc1();
    localObj.puFunc2();
    localObj.pubFunc3();
  }
}