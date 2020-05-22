import android.os.FileObserver;
public class SongDeletedFileObserver extends FileObserver {
    public String absolutePath;
    public MyFileObserver(String path) {
        //not sure if you need ALL_EVENTS but it was the only one in the doc listed as a MASK
        super(path, FileObserver.ALL_EVENTS);
        absolutePath = path;
    }
    @Override
    public void onEvent(int event, String path) {
        if (path == null) {
            return;
        }
        //a new file or subdirectory was created under the monitored directory
        if ((FileObserver.DELETE & event)!=0) {
            //handle deleted file
        }

        //data was written to a file
        if ((FileObserver.MODIFY & event)!=0) {
            //handle modified file (maybe id3 info changed?)
        }

        //the monitored file or directory was deleted, monitoring effectively stops
        if ((FileObserver.DELETE_SELF & event)!=0) {
           //handle when the whole directory being monitored is deleted
        }

        //a file or directory was opened
        if ((FileObserver.MOVED_TO & event)!=0) {
           //handle moved file
        }

        //a file or subdirectory was moved from the monitored directory
        if ((FileObserver.MOVED_FROM & event)!=0) {
            //?
        }

        //the monitored file or directory was moved; monitoring continues
        if ((FileObserver.MOVE_SELF & event)!=0) {
            //?
        }

    }
}