public class YourActivity extends AppCompatActivity implements MyCallBack{
......
......

 @Override
 public void UpdateMyText(String mystr) {
         editText.setText(mystr);
 }
}