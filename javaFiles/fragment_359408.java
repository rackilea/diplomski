String array[] = new String[] {"en","ta", "hi"};
List<String> langList = new ArrayList<>();
for (String item : array) {
    langList.add("\""+item+"\"");
}

System.out.println("langList: "+ langList);

try {
    JSONArray jsonObject = new JSONArray(langList.toString());
    System.out.println("jsonObject: "+jsonObject);
} catch (JSONException e) {
    e.printStackTrace();
}