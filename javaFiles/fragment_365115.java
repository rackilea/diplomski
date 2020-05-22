public class MainActivity extends ActionBarActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private int max = 500;
    private TextView primeText;
    private int previousPrimeNumber;
    private List<Prime> primes;
    private PrimeAdapter adapter;
    private MyDBHandler dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        primeText = (TextView) findViewById(R.id.primeText);

        //get the object from previous session. Remember these are sorted by date
        dbManager = new MyDBHandler(this);
        primes = dbManager.getPrimeObjects();

        //get the first prime. (AKA the last one added)
        if (primes.size() != 0) {
            previousPrimeNumber = primes.get(0).get_primeno(); //get the first item
            primeText.setText(String.valueOf(previousPrimeNumber));
        } else {
            previousPrimeNumber = 2;
        }

        //create list view and adapter to display the data
        ListView listView = (ListView) findViewById(R.id.listView);
        adapter = new PrimeAdapter(this, primes);
        listView.setAdapter(adapter);

        findViewById(R.id.primeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int primeNumber = -1;
                //increment previousPrimeNumber by one so we wont keep using previousPrimeNumber
                for (int i = previousPrimeNumber + 1; i <= max; i++) {
                    if (isPrimeNumber(i)) {
                        primeNumber = i;
                        primeText.setText(String.valueOf(i));
                        previousPrimeNumber = i + 1;
                        break;
                    }
                }

                if (primeNumber != -1) {
                    Prime prime = new Prime(primeNumber);
                    dbManager.addPrime(prime);
                    /* Yes, it saved to our database. But there is no reason for us to read from
                     * it too when we have the prime object right here. So just add it to the
                     * adapter and be done */
                    //The adapter is looking at the list primes. So add it to the top and notify
                    primes.add(0, prime);
                    adapter.notifyDataSetChanged();
                } else {
                    Log.e(TAG, "Oops, there was an error. Invalid prime number");
                }
            }
        });
    }

    public boolean isPrimeNumber(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * If this is too confusing you can ignore it for now.
     * However, I recommend understanding the android UIs before diving in to database storage.
     * Take a look at this link:
     * http://www.vogella.com/tutorials/AndroidListView/article.html
     */
    private class PrimeAdapter extends ArrayAdapter<Prime> {

        public PrimeAdapter(Context context, List<Prime> primes) {
            // I am just using androids views. (android.R.id...)
            super(context, android.R.layout.simple_list_item_2, primes);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            /* This method will automagically get called for every item in the list.
             * This is an ARRAY adapter. So it has a list of the data we passed in on
             * the constructor. So by calling "this" we are accessing it like it were a list
             * which it really is. */

            final Prime prime = this.getItem(position);

            if (view == null) {
                view = LayoutInflater.from(MainActivity.this)
                        .inflate(android.R.layout.simple_list_item_2, null);
            }

            /* if you look at simple_list_item_2, you will see two textViews. text1 and text2.
             * Normally you would create this view yourself, but like i said, that is not the
             * reason I am here */

            // Notice I am referencing android.R.id. and not R.id. That is cause I am lazy and
            // didn't create my own views.
            TextView tv1 = (TextView) view.findViewById(android.R.id.text1);
            TextView tv2 = (TextView) view.findViewById(android.R.id.text2);

            tv1.setText(String.valueOf(prime.get_primeno()));
            tv2.setText(prime.getDateTimeFormatted());

            //now return the view so the listView knows to show it
            return view;
        }

    }