public class MyDownloaderAsyncTask extends AsyncTask<String, Void, Boolean> {

private DownloadManager.DownloadCompletedListner mListner;

private BookProperties mBookDetails;

public MyDownloaderAsyncTask(DownloadManager.DownloadCompletedListner listener, BookProperties bookdetails) {
    mListner=listener;
    mBookDetails=bookdetails;

}

@Override
protected Boolean doInBackground(String... strings) {
    String  tMainFolder = String.valueOf(BaseApplication.getInstance().getAppContext().getDir("MonnFamily", Context.MODE_PRIVATE));
    tMainFolder += "/Book" + mBookDetails.getBookId();
    downloadBookDetails(tMainFolder,  ContentfulConstants.BOOK_MAIN_IMAGE + ".png", mBookDetails.getBookMainImage());
    downloadBookDetails(tMainFolder,  ContentfulConstants.BOOK_MAIN_AUDIO + ".mp3", mBookDetails.getBookSound());

    for (PageDetailProperties pageDetails : mBookDetails.getPageDetail()) {
        String tPageNumber = pageDetails.getPageNumber().toString();
        downloadBookDetails(tMainFolder, ContentfulConstants.PAGE_IMAGE + tPageNumber + ".png", pageDetails.getPageImage());
        downloadBookDetails(tMainFolder,  ContentfulConstants.PAGE_AUDIO + tPageNumber + ".mp3", pageDetails.getPageAudio());
        downloadBookDetails(tMainFolder,  ContentfulConstants.PAGE_TEXT + tPageNumber + ".txt", pageDetails.getPageText());
    }

    return true;
}

protected void onPostExecute(Boolean result) {
    //This is run on the UI thread so you can do as you wish here
    if(result){
        ((LibraryView)BaseApplication.getInstance().getCurrentActivity()).hideActivityView();
        mListner.downloadCompleted();

    }
}

private void downloadBookDetails(String pMainFolder, String pFileName, String pDownloadURL){
    try
    {
        URL url = new URL(pDownloadURL);
        URLConnection ucon = url.openConnection();
        ucon.setReadTimeout(5000);
        ucon.setConnectTimeout(10000);

        InputStream is = ucon.getInputStream();
        BufferedInputStream inStream = new BufferedInputStream(is, 1024 * 5);

        File directory = new File(pMainFolder, pFileName);
        FileOutputStream outStream = new FileOutputStream(directory);
        byte[] buff = new byte[5 * 1024];

        int len;
        while ((len = inStream.read(buff)) != -1)
        {
            outStream.write(buff, 0, len);
        }

        outStream.flush();
        outStream.close();
        inStream.close();
    }
    catch (Exception e)
    {
        //Add Network Error.
        Log.e(TAG, "Download Error Exception " + e.getMessage());
        e.printStackTrace();
    }
}