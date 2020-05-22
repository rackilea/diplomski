public HomeFragment() {
    // Required empty public constructor
}

private ListView lv;

@Override
public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    lv = (ListView) getActivity().findViewById(R.id.lv);
    new mytask().execute("http://musiqikurdi.com/api/get_recent_posts/");
}

@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home,container,false);

    return rootView;
}

public class mytask extends AsyncTask<String,String,List<MusicModel>> {

    @Override
    protected List<MusicModel> doInBackground(String... params) {

        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();

            String line = "";
            while ((line = reader.readLine()) != null)
            {
                buffer.append(line);
            }
            String finalJSON = buffer.toString();
            JSONObject parentobject = new JSONObject(finalJSON);
            JSONArray parentarray = parentobject.getJSONArray("posts");
            StringBuffer finalbufferData = new StringBuffer();


            List<MusicModel> musicModelList = new ArrayList<>();

            for(int i=0; i < parentarray.length(); i++) {
                JSONObject finalobject = parentarray.getJSONObject(i);
                MusicModel musicModel = new MusicModel();
                musicModel.setId(finalobject.getString("id"));
                musicModel.setTitle(finalobject.getString("title").replaceAll("[\\&#8211;]", ""));
                musicModel.setUrl(finalobject.getString("url").replaceAll("[\\&#8211;]", ""));
                musicModel.setDate(finalobject.getString("date").replaceAll("[\\&#8211;]", ""));

                List<MusicModel.category> cateList = new ArrayList<>();
                for(int j = 0; j < finalobject.getJSONArray("categories").length(); j++ )
                {
                    MusicModel.category cate = new MusicModel.category();
                    cate.setCateTitle(finalobject.getJSONArray("categories").getJSONObject(j).getString("title"));
                    cateList.add(cate);
                }
                musicModel.setListCategory(cateList);
                musicModelList.add(musicModel);
            }

            return musicModelList;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }finally {
            if(connection != null) {
                connection.disconnect();
            }
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    @Override
    protected void onPostExecute(List<MusicModel> s) {
        super.onPostExecute(s);
        MusicAdapter adapter = new MusicAdapter(getActivity(),R.layout.row,s);
        lv.setAdapter(adapter);
    }
}
public class MusicAdapter extends ArrayAdapter {
    private List<MusicModel> musicModelList;
    private int resource;
    private LayoutInflater inflater;
    public MusicAdapter(Context context, int resource, List<MusicModel> objects) {
        super(getActivity(), resource, objects);
        musicModelList = objects;
        this.resource = resource;
        inflater = (LayoutInflater) getActivity().getSystemService(getActivity().LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.row,null);
        }
        ImageView img;
        TextView txt1;
        TextView txt2;
        TextView txt3;

        img = (ImageView)convertView.findViewById(R.id.img);
        txt1 = (TextView)convertView.findViewById(R.id.txt1);
        txt2 = (TextView)convertView.findViewById(R.id.txt2);
        txt3 = (TextView)convertView.findViewById(R.id.txt3);

        txt1.setText(musicModelList.get(position).getId());
        txt2.setText(musicModelList.get(position).getTitle());
        return convertView;
    }
}