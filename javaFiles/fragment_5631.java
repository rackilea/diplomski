public class MyClass implements MySubclassA.MyDownloadListener, MySubclassB.MyDownloadListener{
    ...
    public void onDownload(Object payload, Object sender){
        if(sender instanceof MySubclassA){
            ...
        }
        if(sender instanceof MySubclassB){
            ...
        }
    }
}