String input = "[\"477\",\"com.dummybilling\",\"android.test.purchased\",\"inapp:com.dummybilling:android.test.purchased\",\"779\"]";

JSONArray jsonArray = new JSONArray(input);
String[] strArr = new String[jsonArray.length()];

for (int i = 0; i < jsonArray.length(); i++) {
    strArr[i] = jsonArray.getString(i);
}

System.out.println(Arrays.toString(strArr));