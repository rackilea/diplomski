public class MainActivity extends AppCompatActivity {
List<ScreenOneInventory> minventorylist = new ArrayList<ScreenOneInventory>();
List<ScreenOneRows> screenOneRowses = new ArrayList<>();
ArrayList<ItemInterface> finalList = new ArrayList<>();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    String dataStr = "{\n" +
            "  \"rows\": [{\n" +
            "    \"sequence_id\":1,\n" +
            "    \"sequence_description\":\"animal description goes here\",\n" +
            "    \"sequence_image\":\"thumbnail.png\",\n" +
            "    \"sequence_title\": \"Animal\",    \n" +
            "    \"child_rows\":[\n" +
            "      {\n" +
            "        \"id\": \"1\",\n" +
            "        \"name\":\"Lion\",\n" +
            "        \"description\" : \"lion description goes here\",\n" +
            "        \"image\": \"Lion.png\"\n" +
            "\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"2\",\n" +
            "        \"name\":\"Tiger\",\n" +
            "        \"description\" : \"Tiger description goes here\",\n" +
            "        \"image\": \"Tiger.png\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"3\",\n" +
            "        \"name\":\"Elephant\",\n" +
            "        \"description\" : \"Elephant description goes here\",\n" +
            "        \"image\": \"Elephant.png\"\n" +
            "      }       \n" +
            "      ]\n" +
            "  },\n" +
            "{\n" +
            "    \"sequence_id\":2,\n" +
            "    \"sequence_description\":\"animal description goes here\",\n" +
            "    \"sequence_image\":\"thumbnail.png\",\n" +
            "    \"sequence_title\": \"Birds\",    \n" +
            "    \"child_rows\":[\n" +
            "      {\n" +
            "        \"id\": \"1\",\n" +
            "        \"name\":\"Parrot\",\n" +
            "        \"description\" : \"Parrot description goes here\",\n" +
            "        \"image\": \"parrot.png\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": \"2\",\n" +
            "        \"name\":\"Pigeon\",\n" +
            "        \"description\" : \"Pigeon description goes here\",\n" +
            "        \"image\": \"Pigeon.png\"\n" +
            "      },\n" +
            "      {\n" +
            "       \"id\": \"3\",\n" +
            "        \"name\":\"Crow\",\n" +
            "        \"description\" : \"Crow description goes here\",\n" +
            "        \"image\": \"crow.png\"\n" +
            "      }       \n" +
            "      ]\n" +
            "  }  \n" +
            "  ]\n" +
            "}";


    try {
        JSONObject jsonObj = new JSONObject(dataStr);


        JSONArray jsondata = jsonObj.getJSONArray("rows");


        for (int i = 0; i < jsondata.length(); i++) {
            JSONObject rowsdata = jsondata.getJSONObject(i);

            String sequence_id = rowsdata.getString("sequence_id");
            String sequence_description = rowsdata.getString("sequence_description");
            String sequence_image = rowsdata.getString("sequence_image");
            String sequence_title = rowsdata.getString("sequence_title");

            ScreenOneRows soRows = new ScreenOneRows();
            soRows.setSequence_id(sequence_id);
            soRows.setSequence_description(sequence_description);
            soRows.setSequence_image(sequence_image);
            soRows.setSequence_title(sequence_title);
            finalList.add(soRows);

            JSONArray childres = rowsdata.getJSONArray("child_rows");
            for (int j = 0; j < childres.length(); j++) {
                JSONObject inventorydata = childres.getJSONObject(j);
                Log.i("Fragment", "I am here in loop j:" + j);
                String id = inventorydata.getString("id");
                String name = inventorydata.getString("name");
                String description = inventorydata.getString("description");
                String image = inventorydata.getString("image");

                ScreenOneInventory soinventoryObj = new ScreenOneInventory();
                soinventoryObj.setId(id);
                soinventoryObj.setName(name);
                soinventoryObj.setDescription(description);
                soinventoryObj.setImage(image);
                finalList.add(soinventoryObj);

            }

        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        MyCustomAdapter myCustomAdapter = new MyCustomAdapter(finalList, this);
        recyclerView.setAdapter(myCustomAdapter);
    } catch (Exception e) {
        e.printStackTrace();
    }

}
}