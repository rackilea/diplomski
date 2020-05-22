private Document doc;
private ArrayList<String> list = new ArrayList<>();

@Override
protected void onCreat(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_data_mining);

    Thread downloadThread = new Thread() {
        public void run() {
            try {
                doc = Jsoup.connect("http://thewebsite.html").get();

                Elements table = doc.select("table"); 
                Elements rows = table.select("tr");

                for (int i = 0; i < rows.size(); i++) { 
                    org.jsoup.nodes.Element row =  rows.get(i);
                    Elements cols = row.select("td");

                    list.add(cols.get(i).text());
                }

                runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setListAdapter();
                        }
                    }
                );
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    };
    downloadThread.start();
}

private void setListAdapter() {
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.datalayout, list);
    ListView view = (ListView) findViewById(R.id.dataListView);
    view.setAdapter(adapter);
}