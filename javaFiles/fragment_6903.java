class AsyncVideoFolderLoader extends AsyncTask<String, String, List<ModelAudioFolder>> {

    private Cursor cursor;
    List<ModelAudioTe> audioList;

    private String sortBy;

    public AsyncVideoFolderLoader(String sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    protected List<ModelAudioFolder> doInBackground(String... strings) {

        String selection = null;
        String[] projection;
        projection = new String[]{
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.SIZE,
                MediaStore.Audio.Media.ALBUM_ID
        };
        cursor = getActivity().getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                selection,
                null,
                null);
        audioList = new ArrayList<>();
        ModelAudioTe modelAudio;
        while (cursor.moveToNext()) {


            modelAudio = new ModelAudioTe(
                    "" + cursor.getString(0),
                    "" + cursor.getString(1),
                    "" + cursor.getString(2),
                    "" + cursor.getString(3),
                    "" + cursor.getString(4),
                    "" + cursor.getString(5),
                    "" + cursor.getString(6),
                    "" + cursor.getString(7));
            audioList.add(modelAudio);

        }


        //creating audio paths/uris list
        ArrayList<String> pathsList = new ArrayList<>();
        pathsList.clear();
        for (int i = 0; i < audioList.size(); i++) {
            String folderName = new File(audioList.get(i).getDATA()).getParentFile().getName();
            String folderId = new File(audioList.get(i).getDATA()).getParentFile().getParent();
            pathsList.add(folderId + "/" + folderName);
        }


        //generating folder names from audio paths/uris
        List<ModelAudioFolder> folderList = new ArrayList<>();
        folderList.clear();
        for (int i = 0; i < audioList.size(); i++) {

            String folderName = new File(audioList.get(i).getDATA()).getParentFile().getName();
            String folderId = new File(audioList.get(i).getDATA()).getParentFile().getParent();
            int count = Collections.frequency(pathsList, folderId + "/" + folderName);

            String folderRoot;
            String folderRoot1 = "";
            if (audioList.get(i).getDATA().contains("emulated")) {
                folderRoot = "emulated";
            } else {
                folderRoot = "storage";
            }

            if (i > 0) {
                if (audioList.get(i - 1).getDATA().contains("emulated")) {
                    folderRoot1 = "emulated";
                } else {
                    folderRoot1 = "storage";
                }
            }
            if (i == 0) {

                ModelAudioFolder model = new ModelAudioFolder("" + folderId + "/" + folderName, "" + folderName, "", "" + folderId + "/" + folderName, "" + count);
                folderList.add(model);
                Log.d("The_Tag1", "onCreate: " + folderName + " " + folderRoot + " " + folderId + "/" + folderName + " " + count);

            } else if (
                    folderName.equals(new File(audioList.get(i - 1).getDATA()).getParentFile().getName())
                            &&
                            folderRoot.equals(folderRoot1)

            ) {
                //exclude
            } else {
                ModelAudioFolder model = new ModelAudioFolder("" + folderId + "/" + folderName, "" + folderName, "", "" + folderId + "/" + folderName, "" + count);
                folderList.add(model);

                Log.d("The_Tag1", "onCreate: " + folderName + " " + folderRoot + " " + folderId + "/" + folderName + " " + " " + count);

            }

        }


        return folderList;
    }

    @Override
    protected void onPostExecute(List<ModelAudioFolder> audioFolderList) {
        super.onPostExecute(audioFolderList);

        Log.d("ModelAudioFolder_Size", "Count:" + audioFolderList.size());

        try {
            if (audioFolderList.size() <= 0) {
                noFoldersRl.setVisibility(View.VISIBLE);
                foldersRl.setVisibility(View.GONE);
            } else {
                noFoldersRl.setVisibility(View.GONE);
                foldersRl.setVisibility(View.VISIBLE);
            }

            Log.d("FoldersSize", "onPostExecute: " + audioFolderList.size());

            adapterAudioFolder = new AdapterAudioFolder(getActivity(), audioFolderList, dashboardActivity);
            foldersRv.setAdapter(adapterAudioFolder);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}