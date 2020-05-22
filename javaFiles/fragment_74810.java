onCreate() {
....

  GridView gridview = (GridView) findViewById(R.id.GameField);
        gridview.setAdapter(new NumberGridAdapter(this, Arrays.asList(buttons)));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(Game.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class NumberGridAdapter extends BaseAdapter {

        private List<Button> values;
        private Context context;

        public NumberGridAdapter(Context c, List<Button> numbers) {
            context = c;
            values = numbers;
        }

        @Override
        public int getCount() {
            return values.size();
        }

        @Override
        public Object getItem(int position) {
            return values.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = View.inflate(context, R.layout.grid_item_layout, null);
            }

            TextView tv = (TextView) convertView.findViewById(R.id.grid_text_view);
            tv.setText(""+position);


            convertView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    makeMove(values.get(position));
                }
            });


            return convertView;
        }
    }




    public Button[] findButtons() {
        Button[] b = new Button[9];

        b[0] = new Button(this);
        b[0].setText("0");
        b[0].setId(R.id.Button00);

        b[1] = new Button(this);
        b[0].setText("1");
        b[1].setId(R.id.Button01);


        b[2] = new Button(this);
        b[2].setText("2");
        b[2].setId(R.id.Button02);

        b[3] = new Button(this);
        b[3].setText("3");
        b[3].setId(R.id.Button03);

        b[4] = new Button(this);
        b[4].setText("4");
        b[4].setId(R.id.Button04);

        b[5] = new Button(this);
        b[5].setText("5");
        b[5].setId(R.id.Button05);

        b[6] = new Button(this);
        b[6].setText("6");
        b[6].setId(R.id.Button06);

        b[7] = new Button(this);
        b[7].setText("7");
        b[7].setId(R.id.Button07);

        b[8] = new Button(this);
        b[8].setText("8");
        b[8].setId(R.id.Button08);

        return b;
    }