JSONArray arr=(JSONArray)obj.get("methodSet");
if (arr != null) {
    int lengtharr = arr.length();
    MethodClass[] methodSetFinal = new MethodClass[lengtharr];
    JSONObject objMethod1;
    String MethodName, MethodStatus;
    int index = 0;
    for (Object o1 : arr) {
        objMethod1 = (JSONObject) o1;
        MethodName = String.valueOf(objMethod1.get("methodName"));
        MethodStatus = String.valueOf(objMethod1.get("methodStatus"));

        int resultMethodName = Integer.parseInt(MethodName);    
        int resultMethodStatus = Integer.parseInt(MethodStatus);
        MethodClass methodClass = new MethodClass(); 
        //A constructor in your model class that takes two parameters would have been nice
        methodClass.setmethodName(resultMethodName);
        methodClass.setmethodStatus(resultMethodStatus);
        methodSetFinal[index] = methodClass;
        index++;
    }
}