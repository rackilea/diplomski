public class YOUR_SENDING_ACTIVITY extends Activity{

ArrayList<Accordo> chords =null;

      public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.YOURLAYOUT);

         chords = new ArrayList<Accordo>();

         chords.add(new Accordo(R.drawable.do_maggiore,"Do maggiore","Do, Mi, Sol"));
         chords.add(new Accordo(R.drawable.do5,"Do 5","Na, na, na"))

         ImageButton cerca = (ImageButton) findViewById(R.id.search);
         cerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                 intent.putExtra("chords", chords);
                 startActivity(intent);
    }
});


}
}