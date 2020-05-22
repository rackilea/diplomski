public class LoadImages extends AsyncTask
{
    private ArrayAdapter adapter;
    private ArrayList list;

    public LoadImages(ArrayList list, Adapter adapter)
    {
        this.list = list;
        this.adapter = adapter;
    }

    @Override
    protected void onPostExecute(Elements divs)
    {
        super.onPostExecute(result);
        for ( org.jsoup.nodes.Element div : divs )
        {
            list.add(div);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected Void doInBackground(Void... params)
    {
        Document doc = null;
        try
        {
            doc = (Document) Jsoup.connect("http://mongol.co.il/").get();
            return  ((Elements) doc).select("img[src$=.jpg]");
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
        return null;
    }
}