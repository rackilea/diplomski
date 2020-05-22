public class around(non-activity class)
{
Public static String name;
 name = "arjun";
//how to pass this name string to an below activity
}

 public class nameget extends Activity(android activity class)
  {
  around ar = new around();
  //declare non activity class here

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
TextView t1 = (TextView)findViewById(R.id.textView1);
t1.setText(ar.name);
 }
 }