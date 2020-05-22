class MainActivity : AppCompatActivity() {


     @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

              Utils.findEncodersByTypeAsync("abc", infos -> {

          useInfos(infos);
      })