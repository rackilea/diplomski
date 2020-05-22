StringTokenizer s = new StringTokenizer ("Configuration File : Server_intenties = keyId_11503, keyId_11903 : Server_passcodes = keyCode_1678, keyCode_9893", " ");
ArrayList<String> keyCode = new ArrayList();
ArrayList<String> keyId = new ArrayList();


while(s.hasMoreTokens){
    String key = s.nextToken

    if(key.contains("keyId")){
         keyId.add(key);
    }

    if(key.contains("keyCode")){
         keyCode.add(key);
    }
}


System.out.println(keyCode);
System.out.println(keyId);