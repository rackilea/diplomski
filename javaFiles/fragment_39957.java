Customer dtls = new Customer();
String missing = dtls.getList(stingName, intAge, intMob, stingDOB);
JSONArray mJsonArray_miss_dtls = new JSONArray(missing);
Integer length = mJsonArray_miss_dtls.length();
String[] res= new String[lenght];
for (int k = 0; k < lenght; k++) {
    JSONObject missingObject = mJsonArray_miss_dtls.getJSONObject(k);
    String s1 = missingObject.getString("DOB");
    String[] b = s1.split("T");
    String[] b1 = b[0].split("-");
    res[k]=b1[0] + "/" + b1[1];
    cnt++;
}