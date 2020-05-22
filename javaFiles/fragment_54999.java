public class MainActivity extends Activity {
             Public int counter=0;
             Button button;
             ImageView imageview;
             int[] Img_array={R.drawable.bowl1,R.drawable.bowl2};

                @Override
             public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.main);
              button=(Button)findViewById(R.id.MyButton);
              imageview=(ImageView)findViewById(R.id.MyImageView);
               button.setOnClickListener(new View.OnClickListener() {

                            public void onClick(View v) {
                                 imageview.setBackgroundResource(Img_array[counter]);
                                      Counter++;
                                 if(counter==Img_array.length())
                                  {
                                        Counter=0;
                                   }


                                      }
                      });
           }
}