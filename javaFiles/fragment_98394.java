import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;

public class StackActivity extends Activity {
    public static final String[] description = new String[] { "Lorem" };

    public static final String[] description_real = new String[] { "Lorem" };

    public static final String[] openingtimes = new String[] { "Lorem" };

    public static final String[] openingtimes_real = new String[] { "Lorem" };

    public static final String[] prices = new String[] { "Lorem" };

    public static final String[] prices_real = new String[] { "Lorem" };

    public static final Integer[] images = { R.drawable.ic_launcher };

    android.widget.ImageView ImageView;
    android.widget.TextView TextView;
    List<TextItem> TextItems;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextItems = new ArrayList<TextItem>();
        for (int i = 0; i < description.length; i++) {
            TextItem item = new TextItem(images[i], description[i],
                    description_real[i], openingtimes[i], openingtimes_real[i],
                    prices[i], prices_real[i]);
            TextItems.add(item);

            ImageView = (android.widget.ImageView) findViewById(R.id.picture);
            ImageView.setImageResource(TextItems.get(i).getImageId());
            TextView = (android.widget.TextView) findViewById(R.id.description);
            TextView.setText(TextItems.get(i).getdescription());
            TextView = (android.widget.TextView) findViewById(R.id.description_real);
            TextView.setText(TextItems.get(i).getdescription());
            TextView = (android.widget.TextView) findViewById(R.id.openingtimes);
            TextView.setText(TextItems.get(i).getopeningtimes());
            TextView = (android.widget.TextView) findViewById(R.id.openingtimes_real);
            TextView.setText(TextItems.get(i).getopeningtimes_real());
            TextView = (android.widget.TextView) findViewById(R.id.prices);
            TextView.setText(TextItems.get(i).prices());
            TextView = (android.widget.TextView) findViewById(R.id.prices_real);
            TextView.setText(TextItems.get(i).getprices_real());
            TextView.setText(TextItems.get(0).getdescription());
        }
    }
}