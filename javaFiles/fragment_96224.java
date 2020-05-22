public class Task3Activity extends AppCompatActivity {

...

    @Override
    public void onCreate(Bundle savedInstanceSate) {
        ...

        String playerName = getIntent().getStringExtra("PlayerName");

        if (playerName != null) {
            TextView dataRcvd = (TextView) findViewById(R.id.playerNameEntered);
            dataRcvd.setText(playerName);
        }
    }

    ...
}