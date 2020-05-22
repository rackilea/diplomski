public class MainActivity extends AppCompatActivity {    

    String[] word = {"This is text1.So it should be single line", "This is text2", "This is text3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 


        TextView textView = findViewById(R.id.textureView1);
        for (int i = 0; i < word.length; i++) {
            textView.append(word[i]);
            textView.append("\n");
        }



    }


}