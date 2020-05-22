else if(i == 1) 
{
    PostActivity getBlogPostTask = new PostActivity();
    getBlogPostTask.execute();
    rootView = inflater.inflate(R.layout.fragment_articles, container, false);
    ListView listView = (ListView) rootView;
    //convert JSONArray to ArrayList<JSONObject>
    List<JSONOject> data = //convert blogData
    ArrayAdapter<JSONObject> adapter = new ArrayAdapter<JSONObject(getActivity(), R.layout.layout_listitem.xml, data);
    listView.setAdapter(adapter); 
}