// ctor - just calls base ctor an initialzes stuff..
ScanDir::ScanDir(String thisDirPath,DirSearch *mySearch):FmySearch(mySearch),
        FmyDirPath(thisDirPath),fileCount(0),folderCount(0),
        PoolTask(0,mySearch->scanCompleted){};


void ScanDir::run()  // an override - called by pool thread
{
//  fileCount=0;
//  folderCount=0;
    filesAndFolderNames=listAllFoldersAndFiles(FmyDirPath); // gets files
    for (int index = 0; index < filesAndFolderNames->Count; index++)
    { // for all files in the folder..
        if((int)filesAndFolderNames->Objects[index]&faDirectory){
            folderCount++;  //do count and, if it's a folder, start another ScanDir
            String newFolderPath=FmyDirPath+"\\"+filesAndFolderNames->Strings[index];
            ScanDir* newScanDir=FmySearch->getScanDir(newFolderPath);
            myPool->submit(newScanDir);
        }
        else fileCount++; // inc 'ordinary' file count
    }
    delete(filesAndFolderNames); // don't leak the TStringList of filenames
};

DirSearch::DirSearch(String dirPath, TNotifyEvent onComplete):FdirPath(dirPath),
    FonComplete(onComplete),totalFileCount(0),totalFolderCount(0),dirCount(0),
    PoolTask(0,onComplete)
{
    InitializeCriticalSection(&countLock);  // thread-safe count
    searchCompleteEvent=new TEvent(NULL,false,false,"",false); // an event
                                        // for DirSearch to wait on till all ScanDir's done
};

ScanDir* DirSearch::getScanDir(String path)
{  // up the dirCount while providing a new DirSearch
    EnterCriticalSection(&countLock);
    dirCount++;
    LeaveCriticalSection(&countLock);
    return new ScanDir(path,this);
};

void DirSearch::run()  // called on pool thread
{
    ScanDir *firstScanDir=getScanDir(FdirPath); // get first ScanDir for top
    myPool->submit(firstScanDir);               // folder and set it going
    searchCompleteEvent->WaitFor(INFINITE);     // wait for them all to finish
}

/* NOTE - this is a DirSearch method, but it's called by the pool threads
running the DirScans when they complete.  The 'DirSearch' pool thread is stuck
on the searchCompleteEvent, waiting for all the DirScans to complete, at which
point the dirCount will be zero and the searchCompleteEvent signalled.
*/
void __fastcall DirSearch::scanCompleted(TObject *Sender){ // a DirSearch done
    ScanDir* thiscan=(ScanDir*)Sender;  // get the instance that completed back
    EnterCriticalSection(&countLock);   // thread-safe
    totalFileCount+=thiscan->fileCount;     // add DirSearch countst to totals
    totalFolderCount+=thiscan->folderCount;
    dirCount--;                           // another one gone..
    LeaveCriticalSection(&countLock);
    if(!dirCount) searchCompleteEvent->SetEvent(); // if all done, signal
    delete(thiscan);                      // another one bites the dust..
};