try {
        geodatabase = new Geodatabase("/sdcard/Geodatabase/basemap.geodatabase");
    } catch (FileNotFoundException e) {
        Log.e("ERROR", "File Not found");
        e.printStackTrace();
    }