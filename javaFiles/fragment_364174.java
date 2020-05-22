class DirSearch; // forward dec.

class ScanDir:public PoolTask{
    String FmyDirPath;
    DirSearch *FmySearch;
    TStringList *filesAndFolderNames;
public:                              // Counts for FmyDirPath only
    int fileCount,folderCount;
    ScanDir(String thisDirPath,DirSearch *mySearch);
    void run();                        // an override - called by pool thread
};


class DirSearch:public PoolTask{
    TNotifyEvent FonComplete;
    int dirCount;
    TEvent *searchCompleteEvent;
    CRITICAL_SECTION countLock;
public:
    String FdirPath;
    int totalFileCount,totalFolderCount;  // Count totals for all ScanDir's

    DirSearch(String dirPath, TNotifyEvent onComplete);
    ScanDir* getScanDir(String path);      // get a ScanDir and inc's count
    void run();                           // an override - called by pool thread
    void __fastcall scanCompleted(TObject *Sender); // called by ScanDir's
};