public class MainActivity extends AppCompatActivity {

    ChatData mDBHlpr;
    Cursor mCsr;
    MessageAdapter mMesaageAdapter;
    ListView mMessageList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageList = this.findViewById(R.id.messagelist);
        mDBHlpr = new ChatData(this);
        addSomeData();
        mCsr = mDBHlpr.getAllQuestions3();
        mMesaageAdapter = new MessageAdapter(this,mCsr,false);
        mMessageList.setAdapter(mMesaageAdapter);

    }

    private void addSomeData() {
        mDBHlpr.addMessage("Hello",1);
        mDBHlpr.addMessage("Hi",2);
        mDBHlpr.addMessage("How are you?",1);
        mDBHlpr.addMessage("I'm OK thanks, and you?",2);
        mDBHlpr.addMessage("Good.",1);
    }
}