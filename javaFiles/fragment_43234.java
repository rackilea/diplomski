interface Handler{
    void handle( myObject o);
}


 Map<String, Handler> commandMap = new HashMap<>();
 //feel free to factor these out to their own class or
 //if using Java 8 use the new Lambda syntax
 commandMap.put("conditionOne", new Handler(){
         void handle(MyObject o){
                //get desired parameters from MyObject and do stuff
          }
 });
 ...