public class CustomActivity extends Activity implements OnClickListener{

    public void initLayout(Button button){
        button.setOnClickListener(this);
    }
     public void simple_method(){
            System.out.println("test in CustomActivity");
        }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "Button Clicked in Custom Activity", Toast.LENGTH_LONG).show();
    }
}