public class FileChecker {
Timer timer;

public FileChecker(int seconds,File aFileToCheck) {

    timer = new Timer();
    timer.schedule(new FileCheckTask(aFileToCheck),0,seconds*1000);

}




class FileCheckTask extends TimerTask {

private File fileToCheck;

public FileCheckTask(File aFileToCheck){


      fileToCheck = aFileToCheck;
}

    public void run() {
        System.out.format("Checking File....");

        FileUpdated(fileToCheck);
    }


public void FileUpdated(File file) {

this.timeStamp = file.lastModified();

if (this.timeStamp != timeStamp) {
    this.timeStamp = timeStamp;

   //file is updated, do something here

}

}