@Override
public void onClick(DialogInterface dialog, int which) {
    if (arg1 == 0) {
        Intent intentInfo = new Intent(ListViewActivity.this, DialogBox.class);
        // Retrieve the path names of all videos from the top to the
        // selected item (inclusive).
        arrayPath = new String[selectedPosition+1];
        for (int i = 0; i <= selectedPosition; ++i) {
            arrayPath[i] = videoItems.get(i).absolutePath;
        }
        VideoInfo info = videoItems.get(selectedPosition);
        intentInfo.putExtra("fileName", info.name);             
        intentInfo.putExtra("fileSize", info.size);
        intentInfo.putExtra("absolutePath", info.absolutePath);
        intentInfo.putExtra("arrayPath", arrayPath);

        startActivity(intentInfo);  
    }
    else
    {
        deleteFile();
    }
}