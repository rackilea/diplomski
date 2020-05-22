class MainActivity extends Activity implements OnItemSelectedListener {

    GridView cardsGridView;
    private ArrayAdapter<CardButton> cardsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cardsGridView = new GridView(getBaseContext());
        setContentView(cardsGridView);

        CardButton[] cards = getListOfRandomCards();



        cardsAdapter = new ArrayAdapter<CardButton>(this, android.R.layout.simple_spinner_item, cards) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null)
                    convertView = new ImageView(getBaseContext());
                ImageView view = (ImageView) convertView;
                CardButton card = getItem(position);
                int ImageResource;
                if (card.IsSelected()) {
                    ImageResource = card.getCardImage();
                } else {
                    ImageResource = R.drawable.default_card_image;
                }
                view.setImageResource(ImageResource);
                return view;
            }
        };

        cardsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cardsGridView.setAdapter(cardsAdapter);

        cardsGridView.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // To change body of implemented methods use File | Settings | File Templates.
                CardButton card = (CardButton) parent.getItemAtPosition(position);
                card.SetSelected(true);
                ImageView imageView = (ImageView) view;
                imageView.setImageResource(card.getCardImage());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // To change body of implemented methods use File | Settings | File Templates.
            }

        });

    }

}