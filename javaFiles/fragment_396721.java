//Set up a list of objects
fileList={"a","b","c"}
nextIndex=0;
Mutex mutex
//Start_X_threads

String next_object(void){
  String nextFile;
  try{
    mutex.acquire();
    try {
        if (nextFileIndex<fileList.length)
        {
          nextFile=fileList(nextFileIndex);
          nextFileIndex++;
        }
        else
           nextFile="";
    }
    finally
    {
        mutex.release();
    }
  } catch(InterruptedException ie) {
    nextFile="";
  }
  return nextFile;
}