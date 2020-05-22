public class WelcomeOnFootActivity extends AppCompatActivity {
    ImageButton next;
 List<UserDate> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_on_foot);
        Bundle bundle=getIntent().getExtra;
         data= new ArrayList();
        data.add((UserData)bundle.get("data"));
        next=(ImageButton)findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handle();
            }
        });
    }
private void handle(){
      String info=data.getUserInfo;// here i get error
}
}