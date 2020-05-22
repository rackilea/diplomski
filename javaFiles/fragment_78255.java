private void saveSettings() {
    Log.i("class_Aquarium", "-----class_Aquarium saveSettings");

    String line = "";
    try {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
        Log.i("class_Aquarium", "-----class_Aquarium saveSettings read and Write permissions enabled!");
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
        Log.i("class_Aquarium", "-----class_Aquarium loadSettingsFile Read-only permissions enabled");
        return;
        } else {
        Log.i("class_Aquarium", "-----class_Aquarium loadSettingsFile File reading refused!");
        return;
        }
        String fileName = "settings_aquarium";
        try {
        File f = new File(Environment.getExternalStorageDirectory(), fileName);
        FileOutputStream fos2 = null;
        fos2 = new FileOutputStream(f);

        OutputStreamWriter myOutWriter = new OutputStreamWriter(fos2);                

        String datatxt = "test";
        myOutWriter.append(datatxt);
        myOutWriter.close();

        fos2.close();
        Log.i("class_Aquarium", "-----class_Aquarium saveSettings Done writing to file. ");
        } catch (Exception e) {
        e.printStackTrace();
        }

    } finally {

    }
    }