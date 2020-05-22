package infuso.choicemaster;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class activity_main extends AppCompatActivity  {
    public Button Generate;
    public TextView einleitung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize the instance variables
        Generate = (Button) findViewById(R.id.button);
        einleitung = (TextView) findViewById(R.id.textview1);

        final String[] myNames = {"Call the 3rd  person in your Phonebook and ask for activities", "Drive 5 miles with your car just for fun", "Call the 14th person in your Phonebook and ask for activities ",
                "Send a message at whatsapp to a random people in your contacts", "Do a workout",
                "Play old games like n64,playstation 1 or whatever", "Make funny selfies", "Cook something you want", "Watch some films", "Make fresh orange juice ",
                "Climb on a tree", "See how long you can hold a note", "Try to not think about penguins", "Pretend to be a car", "Make Star Trek door noises", "Watch TV, repeat everything said in Italian accent",
                "Buy a postcard an send it to your friend", "Buy a unicorn", "Put a walkie talkie in your mail box and shout at everybody who walks by", "Sing the Llama song till you've annoyed everyone in the room",
                "Start talking in a made up language", "Call your friend, and tell them you can't talk right now, cause your busy", "Go into an elevator with a piece of chalk, draw a box and declare the area your personal space"
                , "Put vanilla pudding in a jar that says MAYO and then eat it in a public place", "go to kfc dressed like a gangster and ask if they have black fried chicken until they kick you out"
                , "Dance around your house"};
        Generate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Auto-generated method sub
                int rando = (int) (Math.random() * 26);
                einleitung.setText(myNames[rando]);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}