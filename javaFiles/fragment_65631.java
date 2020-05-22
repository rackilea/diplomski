public class FindMp3Files extends AppCompatActivity {

    ListView mp3List;

    String title, artist, path, displayName, songDuration;
    ArrayList<Mp3Model> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_mp3_files);

        mp3List = (ListView) findViewById(R.id.mp3List);
        songs = new ArrayList<>();

        scanSdcard();

        SongAdapter adapter = new SongAdapter(this, songs);
        mp3List.setAdapter(adapter);

    }

    private void scanSdcard() {
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";
        String[] projection = {
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DURATION
        };
        final String sortOrder = MediaStore.Audio.AudioColumns.TITLE + " COLLATE LOCALIZED ASC";

        Cursor cursor = null;
        try {
            Uri uri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            cursor = this.getContentResolver().query(uri, projection, selection, null, sortOrder);
            if (cursor != null) {
                cursor.moveToFirst();

                while (!cursor.isAfterLast()) {

                    Mp3Model mp3Model = new Mp3Model();

                    title = cursor.getString(0);
                    artist = cursor.getString(1);
                    path = cursor.getString(2);
                    displayName = cursor.getString(3);
                    songDuration = cursor.getString(4);

                    mp3Model.setTitle(title);
                    mp3Model.setArtist(artist);
                    mp3Model.setPath(path);
                    mp3Model.setDisplayName(displayName);
                    mp3Model.setSongDuration(songDuration);

                    songs.add(mp3Model);

                    cursor.moveToNext();
                }
            }

        } catch (Exception e) {
            Log.e("Tag", e.toString());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}