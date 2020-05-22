public class ExampleActivity extends Activity implements UpdateActivity {
    //etc.

    TextView text; //Init this in the onCreate

    @Override
    void updateText(String text){
         text.setText(text);
    }
}