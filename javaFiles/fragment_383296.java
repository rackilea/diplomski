public class DownloadManager {

private static final String TAG = "Download Manager";

public interface DownloadCompletedListner {
    // you can define any parameter as per your requirement
    public void downloadCompleted();
}

private BookProperties mBookDetails;
private DownloadCompletedListner mListner;

private static final DownloadManager mInstance = new DownloadManager();
public static DownloadManager getInstance() {
    return mInstance;
}


private DownloadManager() {
}






public void downloadBookData(BookProperties pBook){
    mBookDetails = pBook;
    String  tMainFolder = String.valueOf(BaseApplication.getInstance().getAppContext().getDir("MonnFamily", Context.MODE_PRIVATE));
    tMainFolder += "/Book" + pBook.getBookId();

    File directory = new File(tMainFolder);
    if (!directory.exists()) {
        directory.mkdir();
        ((LibraryView)BaseApplication.getInstance().getCurrentActivity()).showActivityView();
        new MyDownloaderAsyncTask(mListner, mBookDetails).execute(new String[]);  

    }
}


public void setListner(DownloadCompletedListner pListner) {
    this.mListner = pListner;
}