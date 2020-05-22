//on Android, use a logger
public class AndroidPrinter implements Printer{
   public void print(String printMe){
      Log.v("example", "index=" + i);
   }
}

//on Android, entry point is Activity
public class AndroidActivity extends Activity{

   public void onCreate(Bundle savedInstanceState) {
      AndroidPrinter printer = new AndroidPrinter ();
      CoreAdder adder = new CoreAdder(printer);
      adder.addAndPrint(1, 2);
   }
}