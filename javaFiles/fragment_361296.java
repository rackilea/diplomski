String name = null;

    File sdCardRoot = Environment.getExternalStorageDirectory();
    File yourDir = new File(sdCardRoot, "/My_records");
    for (File f : yourDir.listFiles()) 
    {
        if (f.isFile())
            name = f.getName();

        selectedPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/My_records/"+name;

        // Do your stuff
        Log.d("selectedPath", selectedPath);
        selectedPathList.add(selectedPath);
    }



    for(int z=0; z<selectedPathList.size();z++)
    {
        Intent i = new Intent(this, FileUploader.class);
        i.putExtra("selectedPath", selectedPathList.get(z));
        i.putExtra("myFileUrl", selectedPathList.get(z));
        startService(i);
    }

}