public class MainActivity extends Activity {
    ArrayList<Contact> imageArry = new ArrayList<Contact>();
    ContactImageAdapter adapter;
    File folder;
    int j = 0;
    Hashmap<String,String> FilesInFolder; //Filename:ModificationDate pairs

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        folder = new File(Environment.getExternalStorageDirectory() + "/tc/");
        FilesInFolder = GetFilesData(folder.getAbsolutePath());

        for (Map.Entry<String, String> current_file:FilesInFolder.entrySet()) {
            //


            imageArry.add(new Contact(R.drawable.ic_launcher, current_file.getKey(), current_file.getValue()));
        }

        adapter = new ContactImageAdapter(this, R.layout.list, imageArry);
        ListView dataList = (ListView) findViewById(R.id.list);
        dataList.setAdapter(adapter);
    }

    public HashMap<String,String> GetFilesData(String DirectoryPath) {
        HashMap<String,String> MyFiles = new HashMap<String,String>();
        File f = new File(DirectoryPath);


        File[] files = f.listFiles();
        if (files.length == 0)
            return null;
        else {
            for (int i=0; i<files.length; i++)  {
                if (files[i].getName().endsWith(".tol")) {
                    long lastTime = files[i].lastModified();
                    String fileName = files[i].getName().substring(0, files[i].getName().lastIndexOf("."));

                    String dateString = DateFormat.format("MM/dd/yyyy", new Date(lastTime)).toString();
                    MyFiles.put(fileName,dateString); //Add the new filename and its modification date to the Hasmap
                }
            }
        }

        return MyFiles;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}