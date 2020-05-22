public class MainActivity extends Activity {

 ImageView imageView;

 Integer[] image = { R.drawable.ic_launcher, R.drawable.tmp,R.drawable.android };

@Override
public void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.splash);

   imageView = (ImageView) findViewById(R.id.img);

   for(i=0;i<2;i++){
        imageView.setImageResource(image[i]);
     }
   }
}