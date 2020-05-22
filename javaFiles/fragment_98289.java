public class ClassServletA {
  public static final AtomicReference<Map<String,String>> myMap = new AtomicReference(new HashMap<>());

   void doGet(HttpServeltRequest request , HttpServletResponse response){
    myMap.get().put("ipaddress", "accessTime");
   }
}

public class MyDailyTask implements Job {
  void executeMethod(){
  //Writing the map object to file or database login here
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream out = new ObjectOutputStream(bos);
    out.writeObject(ClassServletA.myMap.getAndSet(new HashMap<>()));
    out.flush();
    out.close();
    }
}