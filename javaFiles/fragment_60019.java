import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {
   TextView fN;
   TextView sN;
   TextView oP;
   TextView out;
   TextView ht;
   EditText ans;
   Button btn;
   int answer;
   int fNum;
   int sNum;
   int opNum;
   Random r;


@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ht.setVisibility(View.GONE);
    btn = findViewById(R.id.btn);
    fN = findViewById(R.id.fN);
    sN = findViewById(R.id.sN);
    oP = findViewById(R.id.oP);
    out = findViewById(R.id.out);
    ans = findViewById(R.id.Ans);

    final String[] ops = {"+", "-", "÷", "×"};
    final String[] pass = {
            "Very good!",
            "Excellent!",
            "Nice work!",
            "Keep up the good work!"

    };
    final String[] fail = {
            "No. Please try again.",
            "Wrong. Try once more.",
            "Don't give up!",
            "No. Keep trying."
    };

    btn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            ht = findViewById(R.id.hText);


            fN.setText(fNum);
            sN.setText(sNum);
            oP.setText(ops[opNum]);

            int usrAns = Integer.parseInt(valueOf(ans.getText()));

            int rMSG = r.nextInt(pass.length);

            if (answer == usrAns)
                out.setText("" + pass[rMSG]);
            nextQ();
            if (answer != usrAns)
                out.setText("" + fail[rMSG]);
        }
    });
}

public void nextQ() {

    //functionalities variables
    r = new Random();
    fNum = r.nextInt(9);
    sNum = r.nextInt(9);
    opNum = r.nextInt(ops.length);
    if (opNum == 0)
        answer = fNum + sNum;
    if (opNum == 1)
        answer = fNum - sNum;
    if (opNum == 2)
        answer = fNum / sNum;
    if (opNum == 3)
        answer = fNum * sNum;
    ht.setText(answer);
}
}