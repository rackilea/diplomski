public class myObj{
  String myStr;
  int    myInt;
  boolean myBool;
  //get and set methods
}

public static void main(String args[]){
   MyObj o = new MyObj();
   o.setMyStr("str-value");
   Gson gson = new Gson();
   String json = gson.toJson(o);

   o = gson.fromJson(json, MyObj.class);
}