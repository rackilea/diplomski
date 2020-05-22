import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class teste extends AppCompatActivity {

int cashamount = 0;
int cardamount = 0;
int totalamount;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.iuiu);


    EditText et = (EditText) findViewById(R.id.inputamount);
    final String amount = (et.getText().toString());
    RadioGroup rg = (RadioGroup) findViewById(R.id.rgroup);
    rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == R.id.card1) {
                cardamount = Integer.parseInt(cardamount + amount);
            } else if (checkedId == R.id.cash1) {
                cashamount = Integer.parseInt(cashamount + amount);
            } else if (checkedId == R.id.cash2) {
                cashamount -= Integer.parseInt(amount);
            } else if (checkedId == R.id.card2) {
              cardamount -= Integer.parseInt(amount);
            }

        }
    });
    Button button = (Button) findViewById(R.id.button);
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView cash = (TextView) findViewById(R.id.amountcash);
            TextView card = (TextView) findViewById(R.id.amountcard);
            TextView wallet = (TextView) findViewById(R.id.amountwallet);
            cash.setText("Amount in Cash : RS. " + cashamount);
            card.setText("Amount in Card : RS. " + cardamount);
            totalamount = cashamount + cashamount;
            wallet.setText("Total Amount in Wallet : RS. " + totalamount);

        }
    });
}