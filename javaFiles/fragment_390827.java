public class MainActivity extends AppCompatActivity {
Private Button myButton;
@Override
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
}
public void onButtonClick(View v)
   {
      int id = v.getId();  
      switch(id)
         {
          case R.id.signinbutton: signin();break;
          case R.id.logoutbutton: logout();break;
         }
   }
}