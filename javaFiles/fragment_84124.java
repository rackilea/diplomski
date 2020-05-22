public class MainActivity extends Activity{
@Override
public void onCreate(Bundle savedInstanceState){
LinearLayout layout = new LinearLayout(this,new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT); //width and height

Button button = new Button(this);
button.setText("hello");
button.setOnClickListener(new OnClickListener(){
@Override
public void onClick(View v){
Toast.makeText(MainActivity.this,"you clicked me! my text is: "+(Button)v.getText().toString(),Toast.LENGTH_LONG).show();
}
});
}

}