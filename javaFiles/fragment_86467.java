List<Integer> selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    selected = new ArrayList<Long>();
    listView.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            view.setBackgroundColor(Color.BLUE); //mark clicked row
            selected.add(id); //store position of clicked row and to something with it at the end
        }
    });
    }