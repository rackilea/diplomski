public class YourActivity extends Activity {

    private android.support.v7.widget.AppCompatCheckBox mToi;
    private android.support.v7.widget.AppCompatCheckBox mDanikjagran;
    private android.support.v7.widget.AppCompatCheckBox mHtimes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_activity);

        mToi = (android.support.v7.widget.AppCompatCheckBox) findViewById(R.id.toi);
        mDanikjagran = (android.support.v7.widget.AppCompatCheckBox) findViewById(R.id.danikjagran);
        mHtimes = (android.support.v7.widget.AppCompatCheckBox) findViewById(R.id.htimes);

        // ...

        nextscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mToi.isChecked()) {
                    Toast.makeText(this, mToi.getText(), Toast.LENGTH_SHORT).show();
                }
                if (mDanikjagran.isChecked()) {
                    Toast.makeText(this, mDanikjagran.getText(), Toast.LENGTH_SHORT).show();
                }
                if (mHtimes.isChecked()) {
                    Toast.makeText(this, mHtimes.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}