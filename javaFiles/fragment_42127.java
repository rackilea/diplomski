public class parsingjsontest2 extends Activity {
/** Called when the activity is first created. */

public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(main);

String str = connect("http://rentopoly.com/ajax.php?query=Bo"));
System.out.println("String::"+str);
}