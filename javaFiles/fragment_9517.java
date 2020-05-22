@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    final List<Sessions.Session> sessions = new Sessions().getSessions();
    setListAdapter(new BaseAdapter() {

        public int getCount() {
            return sessions.size();
        }

        public Object getItem(int pos) {
            return sessions.get(pos);
        }

        public long getItemId(int pos) {
            return pos;
        }

        public View getView(int pos, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(ViewTest.this, android.R.layout.two_line_list_item, null);
            }

            Sessions.Session session = (Sessions.Session) getItem(pos);

            TextView text = (TextView) view.findViewById(android.R.id.text1);
            text.setText(session.name);

            text = (TextView) view.findViewById(android.R.id.text2);
            text.setText(session.status);
            return view;
        }
    });
}