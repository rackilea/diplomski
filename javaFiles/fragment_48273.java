public class MainActivity extends Activity{

    private ListView listNews;
    private NewsAdapter newsAdapter;
    private ArrayList<String> newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listNews = (ListView) findViewById(R.id.listNews);

        newsList = new ArrayList<String>();
        newsList.add("News 1");
        newsList.add("News 2");
        newsList.add("News 3");
        newsList.add("News 4");
        newsList.add("News 5");
        newsList.add("News 6");
        newsList.add("News 7");
        newsList.add("News 8");
        newsList.add("News 9");

        newsAdapter = new NewsAdapter(this,newsList);
        listNews.setAdapter(newsAdapter);
        listNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,newsList.get(position),Toast.LENGTH_SHORT).show();
            }
        });

    }


    class NewsAdapter extends BaseAdapter{

        private Context context;
        private ArrayList<String> newsList;

        public NewsAdapter(Context context,ArrayList<String> newsList){
            this.context = context;
            this.newsList = newsList;
        }

        @Override
        public int getCount() {
            return newsList.size();
        }

        @Override
        public Object getItem(int position) {
            return newsList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if(convertView==null){
                holder = new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.list_item,null,false);
                holder.bdNewsTex = (TextView) convertView.findViewById(R.id.bdNewsTex);
                convertView.setTag(holder);
            }else{
                holder =(ViewHolder) convertView.getTag();
            }

            holder.bdNewsTex.setText(newsList.get(position));
            return convertView;
        }

        class ViewHolder {
            TextView bdNewsTex;
        }
    }

}