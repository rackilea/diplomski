public class MainActivity extends AppCompatActivity implements View.OnClickListener{
static long DELAY_TIME_INPUT = 500;
static int INPUT_TYPE_NORMAL = 0;
static int INPUT_TYPE_CAP = 1;
static int INPUT_TYPE_NUM = 2;

TextView txtMessage;
int[] mAlphabetTable1 = new int[]{1, 3, 9, 25, 17, 11, 27, 19, 10, 26,
                                5, 7, 13, 29, 21, 15, 31, 23, 14, 30,
                                37, 39, 58, 45, 61, 53};
int[] mSymbolTable1 = new int[]{2, 6, 4, 18, 36, 40, 50, 22, 38, 52, 54, 12};
/* Note: The value used below {8, 16, 20, 24} are just an example.
    I choose these values because they are not defined on the above tables.
  */
int[] mSpecialTable1 = new int[]{8, 16, 20, 24};

// char[] mAlphabetTable2 = new char[]{};
char[] mNumberTable2 = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
char[] mSymbolTable2 = new char[]{',', ';', '\'', ':','-', '.', '.', '!', '“', '”','(','/'};
int mCurrentAlphabet = 0;
int mCurrentInputType = 0;
long mLastTimeStamp;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Window window = this.getWindow();
    window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
    window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
    window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
    // Init GUI
    txtMessage = (TextView) findViewById(R.id.txtMesssage);
    Button buttonOne = (Button) findViewById(R.id.block1);
    Button buttonTwo = (Button) findViewById(R.id.block2);
    Button buttonThree = (Button) findViewById(R.id.block3);
    Button buttonFour = (Button) findViewById(R.id.block4);
    Button buttonFive = (Button) findViewById(R.id.block5);
    Button buttonSix = (Button) findViewById(R.id.block6);
    // Attached Click Listener
    buttonOne.setOnClickListener(this);
    buttonTwo.setOnClickListener(this);
    buttonThree.setOnClickListener(this);
    buttonFour.setOnClickListener(this);
    buttonFive.setOnClickListener(this);
    buttonSix.setOnClickListener(this);
}

@Override
public void onClick(View view) {
    switch (view.getId()){
        case R.id.block1: mCurrentAlphabet |=1; break;
        case R.id.block2: mCurrentAlphabet |=2; break;
        case R.id.block3: mCurrentAlphabet |=4; break;
        case R.id.block4: mCurrentAlphabet |=8; break;
        case R.id.block5: mCurrentAlphabet |=16; break;
        case R.id.block6: mCurrentAlphabet |=32; break;
    }
    view.setBackgroundColor(Color.BLACK);
    Button btView = (Button) view;
    btView.setTextColor(Color.WHITE);
    mLastTimeStamp = System.currentTimeMillis();
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            long currentTimeStamp = System.currentTimeMillis();
            if(currentTimeStamp - mLastTimeStamp > DELAY_TIME_INPUT){
                genNewBrailleAlphabet();
            }
        }
    }, DELAY_TIME_INPUT + 10);
}

public void genNewBrailleAlphabet(){
    if(mCurrentAlphabet == 32 || mCurrentAlphabet == 60){ // Check if input is Cap or Num sign?
        if(mCurrentAlphabet == 32){ // Input is Cap sign.
            mCurrentInputType = INPUT_TYPE_CAP;
            TextView txtCap = (TextView) findViewById(R.id.cap);
            txtCap.setBackgroundColor(Color.GREEN);
        } else { // Input is Num sign.
            TextView txtNum = (TextView) findViewById(R.id.num);
            if(mCurrentInputType == INPUT_TYPE_NUM){
                mCurrentInputType = INPUT_TYPE_NORMAL; // Turn off Num sign.
                txtNum.setBackgroundColor(Color.TRANSPARENT);
            } else {
                mCurrentInputType = INPUT_TYPE_NUM; // Turn on Num sign.
                txtNum.setBackgroundColor(Color.GREEN);
            }
        }
    } else { // Input is not Cap or Num sign.
        byte currentAlphabetIndex = -1;
        char newAlphabet = 0;
        for (int i = 0; i < mAlphabetTable1.length; i++) {
            if (mAlphabetTable1[i] == mCurrentAlphabet) {
                currentAlphabetIndex = (byte) i;
                break;
            }
        }
        if(currentAlphabetIndex != -1) { // Check if input is Numbers or Alphabets?
            if (mCurrentInputType == INPUT_TYPE_NUM) { // Input is Numbers.
                if(currentAlphabetIndex < 10) {
                    newAlphabet = mNumberTable2[currentAlphabetIndex];
                }
            } else if (mCurrentInputType == INPUT_TYPE_CAP) // Input is Alphabets.
                newAlphabet = (char) (currentAlphabetIndex + 'A');
            else newAlphabet = (char) (currentAlphabetIndex + 'a');

            String msg = txtMessage.getText().toString() + newAlphabet;
            txtMessage.setText(msg);
        } else { // Input is not Numbers or Alphabets.
            for (int i = 0; i < mSymbolTable1.length; i++) {
                if (mSymbolTable1[i] == mCurrentAlphabet) {
                    currentAlphabetIndex = (byte) i;
                    break;
                }
            }
            if(currentAlphabetIndex != -1) { // Check if input is Punctuations?
                newAlphabet = mSymbolTable2[currentAlphabetIndex];
                if(currentAlphabetIndex == 8){ // Open Quote, Question Mark have the same pattern.
                    String tmpString = txtMessage.getText().toString();
                    if(tmpString.length() > 0 && !tmpString.endsWith(" ")){
                        // Last typed alphabet is not space, so this is Question Mark.
                        newAlphabet = '?';
                    }
                }
                String msg = txtMessage.getText().toString() + newAlphabet;
                txtMessage.setText(msg);
            } else { // Input is not Punctuations, so it is Special Action or undefined.
                for (int i = 0; i < mSpecialTable1.length; i++) {
                    if (mSpecialTable1[i] == mCurrentAlphabet) {
                        currentAlphabetIndex = (byte) i;
                        break;
                    }
                }
                if(currentAlphabetIndex != -1) { // Check if input is Special Action?
                    String msg = txtMessage.getText().toString();
                    // Input is Special Action
                    switch (currentAlphabetIndex) {
                        case 0: // Change focus here
                            // Change focus code
                            /* if (txtNumber.hasFocus()) {
                                txtMessage.requestFocus();
                            } else {
                                txtNumber.requestFocus();
                            } */
                            break;
                        case 1: // BackSpace
                            msg = msg.substring(0, msg.length() - 1);
                            txtMessage.setText(msg);
                            break;
                        case 2: // Space
                            msg = msg + " ";
                            txtMessage.setText(msg);
                            break;
                        case 3: // New Line
                            msg = msg + "\n";
                            break;
                    }
                    txtMessage.setText(msg);
                } else { // Input not defined.
                    Toast.makeText(getApplicationContext(), "Clicked button combination not defined!!", Toast.LENGTH_SHORT).show();
                }
            }
        }

        if(mCurrentInputType == INPUT_TYPE_CAP){
            TextView txtCap = (TextView) findViewById(R.id.cap);
            txtCap.setBackgroundColor(Color.TRANSPARENT);
            mCurrentInputType = INPUT_TYPE_NORMAL;
        }
    }
    // Reset button views ana variable for next alphabet.
    Button buttonOne = (Button) findViewById(R.id.block1);
    Button buttonTwo = (Button) findViewById(R.id.block2);
    Button buttonThree = (Button) findViewById(R.id.block3);
    Button buttonFour = (Button) findViewById(R.id.block4);
    Button buttonFive = (Button) findViewById(R.id.block5);
    Button buttonSix = (Button) findViewById(R.id.block6);
    buttonOne.setBackgroundColor(Color.WHITE);
    buttonTwo.setBackgroundColor(Color.WHITE);
    buttonThree.setBackgroundColor(Color.WHITE);
    buttonFour.setBackgroundColor(Color.WHITE);
    buttonFive.setBackgroundColor(Color.WHITE);
    buttonSix.setBackgroundColor(Color.WHITE);
    buttonOne.setTextColor(Color.BLACK);
    buttonTwo.setTextColor(Color.BLACK);
    buttonThree.setTextColor(Color.BLACK);
    buttonFour.setTextColor(Color.BLACK);
    buttonFive.setTextColor(Color.BLACK);
    buttonSix.setTextColor(Color.BLACK);
    mCurrentAlphabet = 0;
}}