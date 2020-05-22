public class Main extends AppCompatActivity {

    boolean isMainContentSet = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);
    }
    public void clicked(View v){
        switch (v.getId()){
            case R.id.a:
                setContentView(R.layout.alayout);
                isMainContentSet = false;
                break;
            case R.id.b:
                setContentView(R.layout.blayout);
                isMainContentSet = false;
                break;
        }
     }


    @Override
    public void onBackPressed() {
        //your code when back button pressed
        if(!isMainContentSet){
            setContentView(R.layout.mainlayout);
            isMainContentSet = true;
        }else{
            super.onBackPressed();
        }
    }

}