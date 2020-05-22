@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.champions);

    ImageButton ibAnnie = (ImageButton) findViewById(R.id.ibAnnie);

    ibAnnie.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View arg0) {
            RelativeLayout test = (RelativeLayout) findViewById(R.id.layoutChampions);
            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View createView = layoutInflater.inflate(R.layout.create_build_page, null);
            test.addView(createView);

            ImageButton img = (ImageButton) view.findViewById(R.id.ibChamp);
            img.setImageResource(R.drawable.ic_launcher);
            img.setTag(R.drawable.ic_launcher); // so you can retrieve it later
            img.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    // this will set the imageView of ibAnnie
                    ibAnnie.setImageView((Integer)view.getTag());
                    // this will remove the selection view from your layout
                    ((RelativeLayout) findViewById(R.id.layoutChampions)).removeChild(createView);
                }
            });

            // this opens another Activity... you don't want that, at least not for what you seem to be trying to do.
            /*try {
                Intent open = new Intent("android.intent.action.CREATE");
                startActivity(open);
            } catch (Exception e) {

            }*/

        }
    });
}