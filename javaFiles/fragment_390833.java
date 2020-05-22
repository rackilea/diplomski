public static final String FRAGMENTA = "FragmentA";
public static final String FRAGMENTB = "FragmentB";
public static final String FRAGMENTC = "FragmentB";

String fragmentToDisplay = FRAGMENTA;
Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
intent.putExtra("fragmentToDisplay", fragmentToDisplay);
startActivity(intent);