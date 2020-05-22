public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button asc = (Button) findViewById(R.id.asc);
        Button desc = (Button) findViewById(R.id.desc);
        final ArrayList<Location> actorsList = new ArrayList<Location>();

        Location loc = new Location();
        loc.setName("1");
        loc.setPrice("4000");
        actorsList.add(loc);

        loc = new Location();
        loc.setName("2");
        loc.setPrice("8000");
        actorsList.add(loc);

        loc = new Location();
        loc.setName("3");
        loc.setPrice("1000");
        actorsList.add(loc);

        loc = new Location();
        loc.setName("4");
        loc.setPrice("16000");
        actorsList.add(loc);

        asc.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Collections.sort(actorsList, new Comparator<Location>() {
                    @Override
                    public int compare(Location arg1, Location arg2) {
                        Integer obj1 = new Integer(arg1.getPrice().replace(",",""));
                        Integer obj2 = new Integer(arg2.getPrice().replace(",",""));
                        return (Integer) (obj1).compareTo(obj2);
                    }
                });

                for (int i = 0; i < actorsList.size(); i++) {
                    System.out.println("monika 1233"
                            + actorsList.get(i).getPrice());
                }
            }
        });

    }

}