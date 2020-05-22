String key="book";//array key (as it mentioned in your Json)
Response response=//your API call which will return Json Object
List<Hash<String,Object>>booksList=response.jsonPath().getList(key);
//Now parse value from List
Hash<String,Object> firstBookDetails=booksList.get(0);// for first index
String author=(String)firstBookDetails.get("author");