public class add2cart extends Activity{
ListView adlstvw;
Button btn,remove_btn;
SQLiteDatabase mydb;
public static boolean first_init = true;
@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.add2crt);
    adlstvw=(ListView)findViewById(R.id.lstvw_add2crt);
    btn=(Button)findViewById(R.id.place_order);
    if(first_init){
      final String sme = "some_value";
      first_init = false;
    }else{
     Intent in=getIntent();
     Bundle bundl=in.getExtras();
     final String sme=bundl.getString("dtls");
    }
    .
    .
    .
}