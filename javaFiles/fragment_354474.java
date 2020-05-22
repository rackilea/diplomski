DatabaseHandler db = new DatabaseHandler(getApplicationContext());
HashMap<String,String> userDetail= db.getUserDetails();
if (userDetail != null) {
  String level = userDetail.get("level");
  if (level != null){
    try {
      int userLevel = Integer.parseInt(level);
    } catch (Exception e){
     e.printStackTrace();
    }
  }
}