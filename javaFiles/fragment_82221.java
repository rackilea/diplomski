public class OutagesActivity extends ListActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Please don't create objects like this. This is just an example
        Outages outagesObject = new Outages();
        outagesObject.outagnumber = jsonValue;
        outagesObject.impact = jsonValue;
        outagesObject.status = jsonValue;
        outagesObject.timestamp = jsonValue;

        List<Outages> listOfOutagesObjects = new ArrayList<Outages>();
        listOfOutagesObjects.add(outagesObject);
        listOfOutagesObjects.add(outagesObject2);

        OutagesAdapter adapter = new OutagesAdapter(listOfOutagesObjects);
        setListAdapter(adapter);
    }
}