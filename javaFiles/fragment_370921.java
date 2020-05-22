import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView olds;
    RadioButton check1, check2, check3, check4;
    CheckBox check5, check52, check53;

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        olds = (TextView) findViewById(R.id.ShowScore);
        check1 = (RadioButton) findViewById(R.id.right1);
        check2 = (RadioButton) findViewById(R.id.right2);
        check3 = (RadioButton) findViewById(R.id.right3);
        check4 = (RadioButton) findViewById(R.id.right4);
        check5 = (CheckBox) findViewById(R.id.right51);
        check52 = (CheckBox) findViewById(R.id.right52);
        check53 = (CheckBox) findViewById(R.id.right53);
    }

    public void setScore(View v) {

        boolean doit1 = check1.isChecked();
        boolean doit2 = check2.isChecked();
        boolean doit3 = check3.isChecked();
        boolean doit4 = check4.isChecked();
        boolean doit5 = check5.isChecked();
        boolean doit52 = check52.isChecked();
        boolean doit53 = check53.isChecked();

        updateScore(doit1);
        updateScore2(doit2);
        updateScore3(doit3);
        updateScore4(doit4);
        updateScore5(doit5, doit52, doit53);
        showScore();
    }

    private int updateScore(boolean doit1) {
        if (doit1) {
            score = score + 1;
        } else {
            score = score - 1;
        }
        return score;
    }

    private int updateScore2(boolean doit2) {
        if (doit2) {
            score = score + 1;
        } else {
            score = score - 1;
        }
        return score;
    }

    private int updateScore3(boolean doit3) {
        if (doit3) {
            score = score + 1;
        } else {
            score = score - 1;
        }
        return score;
    }

    private int updateScore4(boolean doit4) {
        if (doit4) {
            score = score + 1;
        } else {
            score = score - 1;
        }
        return score;
    }

    private int updateScore5(boolean doit5, boolean doit52, boolean doit53) {
        if (doit5 && doit52 && doit53) {
            score = score + 1;
        } else {
            score = score - 1;
        }
        return score; 
    }

    private void showScore() {
        olds.setText(String.valueOf(score));
    }
}