package foo;

import java.util.function.BiConsumer;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

public class SideEffects{
  public static void main(String args[]){
    System.out.println("Calling logic as a pure function");
    String result = logic("param1", "param2", null, null, null, null, null);
    System.out.println("Result is "+result);
    System.out.println();

    System.out.println("Calling logic as a regular function");
    result = logic("param1", "param2",
        (level,msg)->{System.out.println("LOG ["+level+"]["+msg+"]");},
        (status)->{System.out.println("Current status set to: "+status); },
        (obj)->{System.out.println("Called notify message on object: "+obj.toString());},
        ()->{boolean dbLookupResult = false; return dbLookupResult;},
        (info)->{System.out.println("Info written to file [["+info+"]]");}
        );
    System.out.println("Result is "+result);
  }

  public static String logic(String param1, String param2,
      BiConsumer<String, String> log,
      Consumer<String> setStatus,
      Consumer<Object> notify,
      BooleanSupplier eStop,
      Consumer<String> saveFile){
  if (setStatus != null){ setStatus.accept("running"); }
  String s1 = param1+"::"+param2;
  if (log != null){ log.accept("INFO", "About to do Step 2, this could take awhile"); }
  String s2 = s1+"::step2";
  if (log != null){ log.accept("INFO", "Completed step 2"); }
  String s3 = s2+"::step3";
  if (notify != null) { notify.accept("randomobjectnotify"); }
  if (eStop != null && eStop.getAsBoolean()){
    if (setStatus != null){ setStatus.accept("stopped"); }
    return "stoppedresult";
  }
  String s4 = s3+"::step4";
  if (setStatus != null){ setStatus.accept("completed"); }
  if (saveFile!= null){ saveFile.accept("Logic completed for params "+param1+"::"+param2); }
  return s4;
  }
}