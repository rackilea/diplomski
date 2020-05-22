import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

TextView tv;
EditText et;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    tv = (TextView) findViewById(R.id.out);
    et = (EditText) findViewById(R.id.txt);

    String [] res = executeInShell("ip route show").split("\n");
    String gatewayInfo [] = res[0].split(" ");

    et.setText("ip route show");
    et.setSelection(et.getText().length());

    tv.setText(gatewayInfo[2].toString());

    Log.d("Response", executeInShell("ip route show"));


}

public static String executeInShell(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String response = output.toString();
        return response;

   }

}