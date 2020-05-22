import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.testing) {

            doAction();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void doAction() {
        // Do something...
        Toast.makeText(getApplicationContext(), "Clicked!", Toast.LENGTH_SHORT).show();
    }
}