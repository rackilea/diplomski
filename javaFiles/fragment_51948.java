public class ParsingThread implements Runnable{
private String fileName;

public ParsingThread(String fName){
    fileName = fName;
}

@Override
public void run(){
    parseFileAndSaveToDB(fileName);

}
public void parseFileAndSaveToDB(String fileName){
    //your implementation
}



public static void main(String args[]){
    for(String fileName : args){
        Thread runAndStore = new Thread(new ParsingThread(fileName));
        runAndStore.run();
    }

  }
}