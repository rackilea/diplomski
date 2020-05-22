import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.Button;
    import android.widget.EditText;

    public class Calculator extends Activity implements OnClickListener{

        private static EditText mShowResult;
        private static Button mMode;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.display);

            mMode = (Button) findViewById(R.id.bMode);
            mShowResult = (EditText) findViewById(R.id.result_id);

            if (mMode != null) {
                mMode.setOnClickListener(this);
            }
        }

        @Override
        public void onClick(View view) {
            if(view == mMode) {
                Intent intent = new Intent();
                intent.setClass(this, SwitchMode.class);
                startActivity(intent);
            }
        }
    }