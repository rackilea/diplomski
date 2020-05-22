JSONObject get_string = new JSONObject(t);

 String userid = (String) get_string.get("UserId");
 String totalusers = (String) get_string.get("TotalUsers");
 String SessionID = (String) get_string.get("SessionID");

 int i=0;
 JSONObject obj=null;

 /* Initialize the List<Contact> */
 List<Contact> list=new ArrayList();

 while(get_string.has("contacts-"+i))
  {
   obj=get_string.getJSONObject("contacts-" + i);
   Contact contact=new Contact();
   contact.setUserId(obj.getString("UserId"));
   contact.setUserName(obj.getString("UserName"));
   contact.setStatus(obj.getString("Status"));
   list.add(contact);
   i++;
  }