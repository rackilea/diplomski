public class QuizActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mToggle;

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    Dialog dialog;
    Dialog dialog2;
    TextView closeButton;
    TextView closeButton2;
    CheckBox checkBoxmp;
    private MediaPlayer mp, mp2;

    SharedPreferences mypref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        //Dialog 1
        createDialog();
        Button dialogButton = (Button) findViewById(R.id.dialogbtn);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();

            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        //end Dialog 1

        //Dialog 2
        createDialog2();
        Button dialogButton2 = (Button) findViewById(R.id.dialogbtn2);
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.show();

            }
        });


        closeButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.dismiss();
            }
        });
        //end Dialog 2

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);

        final SharedPreferences.Editor editor = mypref.edit();

        checkBoxmp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor.putBoolean("playSounds", !isChecked);
                editor.commit();
                if (null != mp && null != mp2) {
                    if (!isChecked) {
                        mp.setVolume(1, 1);
                        mp2.setVolume(1, 1);
                    } else {
                        mp.setVolume(0, 0);
                        mp2.setVolume(0, 0);
                    }
                }
            }
        });

        final boolean playSounds = mypref.getBoolean("playSounds", false);
        checkBoxmp.setChecked(!playSounds);

        TextView shareTextView = (TextView) findViewById(R.id.share);
        shareTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                myIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello!");
                myIntent.putExtra(Intent.EXTRA_TEXT, "My highscore in Quizzi is very high! I bet you can't beat me except you are cleverer than me. Download the app now! https://play.google.com/store/apps/details?id=amapps.impossiblequiz");
                startActivity(Intent.createChooser(myIntent, "Share with:"));
            }
        });

        mQuestionLibrary.shuffle();

        setSupportActionBar((Toolbar) findViewById(R.id.nav_action));
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Able to see the Navigation Burger "Button"

        ((NavigationView) findViewById(R.id.nv1)).setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_stats:
                        startActivity(new Intent(QuizActivity.this, Menu2.class));
                        break;
                    case R.id.nav_about:
                        startActivity(new Intent(QuizActivity.this, Menu3.class));
                        break;
                }
                return true;
            }
        });

        mScoreView = (TextView) findViewById(R.id.score_score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);

        final List<Button> choices = new ArrayList<>();
        choices.add(mButtonChoice1);
        choices.add(mButtonChoice2);
        choices.add(mButtonChoice3);

        updateQuestion();


        //Code of the mediaplayer begins:

        for (final Button choice : choices) {
            choice.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (choice.getText().equals(mAnswer)) {
                        try {
                            mp = new MediaPlayer();
                            if (playSounds) {
                                mp.setVolume(1, 1);
                            } else {
                                mp.setVolume(0, 0);
                            }

                            AssetFileDescriptor afd;
                            afd = getAssets().openFd("sample.mp3");
                            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                            mp.prepare();

                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });
                        mp.start();
                        updateScore();
                        updateQuestion();
                        Toast.makeText(QuizActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                    } else {
                        try {
                            mp2 = new MediaPlayer();
                            if (playSounds) {
                                mp2.setVolume(1, 1);
                            } else {
                                mp2.setVolume(0, 0);
                            }
                            AssetFileDescriptor afd;
                            afd = getAssets().openFd("wrong.mp3");
                            mp2.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                            mp2.prepare();

                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        mp2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                mp.release();
                            }
                        });
                        mp2.start();

                        Toast.makeText(QuizActivity.this, "Wrong... Try again!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(QuizActivity.this, Menu2.class);
                        intent.putExtra("score", mScore); // pass score to Menu2
                        startActivity(intent);
                    }
                }
            });
        }
    }


    //End mediaplayer main code
    private void updateQuestion() {
        if (mQuestionNumber < mQuestionLibrary.getLength()) {
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber++);
        } else {
            Toast.makeText(QuizActivity.this, "Last Question! You are very intelligent!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuizActivity.this, Menu2.class);
            intent.putExtra("score", mScore);
            startActivity(intent);
        }
    }

    private void updateScore() {
        mScoreView.setText(String.valueOf(++mScore));

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highScore = mypref.getInt("highScore", 0);

        if (mScore > highScore) {
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highScore", mScore);
            editor.apply();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    private void createDialog() {
        dialog = new Dialog(this);
        dialog.setTitle("Tutorial");
        dialog.setContentView(R.layout.popup_menu1_1);
        closeButton = (TextView) dialog.findViewById(R.id.closeTXT);
    }


    private void createDialog2() {
        dialog2 = new Dialog(this);
        dialog2.setTitle("Settings");
        dialog2.setContentView(R.layout.popup_menu1_2);
        closeButton2 = (TextView) dialog2.findViewById(R.id.closeTXT2);
        checkBoxmp = (CheckBox) dialog2.findViewById(R.id.ckeckBox);
    }
}