public class MainActivity extends AppCompatActivity {  
  RelativeLayout layout1;  // Make it class scope.

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    //set layout
    super.onCreate(savedInstanceState);
    RelativeLayout layout1 = new RelativeLayout(this);
    layout1.setBackgroundColor(Color.BLACK);
    ...
  }

  // Then you can access it from other method:
  private void colors() {
    Random random = new Random();
    short num1 = (short)random.nextInt(9);

    if(num1 == 0) {
       layout1.setBackgroundColor(Color.BLACK); // You can access it now.
    }
  }