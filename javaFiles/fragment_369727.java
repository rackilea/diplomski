public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn1)
    protected Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}