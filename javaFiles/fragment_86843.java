@Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.card_categories);
       addButton = (ImageButton) findViewById(R.id.add_category_button);
       addButton.setOnClickListener(myCardsHandler);
   }

   OnClickListener myCardsHandler = new OnClickListener() {
       public void onClick(View v) {

           loadCategories(dbHandler, categories);
       }
   };