//Parse it as integer
int feedCountFromUI = Integer.valueOf(count);

//Do a list and call your function to get all feeds from DB.
MyService myService = new MyService();
List<MyBean> feeds = myService.getAll();

//JSON variable
JSONObject result = new JSONObject();

//Fill your JSON variable
for(MyBean mb : feeds) {
   //Build a json with your feeds and fill result
}