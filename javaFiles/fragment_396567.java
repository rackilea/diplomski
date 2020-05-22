private FileFilter mFileFilter;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    mFileFilter = new AudioFilter();

    ListView listsong =(ListView)findViewById(R.id.songslistView);

    ArrayList<String> mp3list = new ArrayList<String>();
    ArrayList<File> fileList = new ArrayList<File>();
    File home = new File(MEDIA_PATH);
    mp3select(home, fileList);
    //now you need to map your ArrayList<File> to ArrayList<String>.  Personally I would use a different kind of adapter and just return the name of the file while keeping the entire file reference


    ArrayAdapter<String> listAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,mp3list);
    listsong.setAdapter(listAdapter);

}

public void mp3select(File dir, ArrayList<File> fileList){  
    if (!home.isDirectory()) {
        return;
    }
    for (File file : home.listFiles(mAudioFilter))
    {
        if (file.isDirectory()) {
           mp3List(file, fileList);
        } else {
           fileList.add(file);
        }
    }
}