public class MainActivity extends AppCompatActivity {

Button btn1;
Button btn2;

ProgressBar myBar;

TextView score1;
TextView score2;

TextView percent1;
TextView percent2;

private float firstClicked;
private float secondClicked;

@RequiresApi(api = Build.VERSION_CODES.N)
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btn1 = findViewById(R.id.btn1);
    btn2 = findViewById(R.id.btn2);

    myBar = findViewById(R.id.progressBar);

    score1 = findViewById(R.id.score1);
    score2 = findViewById(R.id.score2);

    percent1 = findViewById(R.id.percent1);
    percent2 = findViewById(R.id.percent2);


    firstClicked = 0;
    secondClicked = 0;

    btn1.setOnClickListener(new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View v) {
            firstClicked++;
            score1.setText(String.valueOf((int) firstClicked));
            updateProgressTab();
        }
    });

    btn2.setOnClickListener(new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void onClick(View v) {
            secondClicked++;
            score2.setText(String.valueOf((int) secondClicked));
            updateProgressTab();
        }
    });

    updateProgressTab();
}

@SuppressLint("SetTextI18n")
@RequiresApi(api = Build.VERSION_CODES.N)
public void updateProgressTab() {
    float progress;

    if (firstClicked != 0 && secondClicked != 0) {
        progress = (firstClicked / (firstClicked + secondClicked)) * 100;
        percent1.setText((int) progress + "%");
        percent2.setText((int) (100 - progress) + "%");
    } else if (firstClicked == 0 && secondClicked == 0) {
        progress = 50;
    } else if (firstClicked == 0) {
        progress = 0;
    } else {
        progress = 100;
    }

    percent1.setText((int) progress + "%");
    percent2.setText((int) (100 - progress) + "%");

    myBar.setProgress((int) progress, true);
}