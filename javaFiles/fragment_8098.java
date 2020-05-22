import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ReadFile implements Callable<String>
{
  public static void main(String[] args) throws InterruptedException
  {
    // enter the three file names here
    String[] file={
      "",
      "",
      ""};
    ExecutorService executorService = Executors.newFixedThreadPool(file.length);
    List<Callable<String>> jobs=new ArrayList<>(file.length);
    for(String f:file) jobs.add(new ReadFile(f));
    List<Future<String>> all = executorService.invokeAll(jobs);
    System.out.println("all files have been read in");
    int i=0; for(Future<String> f:all) { i++;
      System.out.println("file "+i+": ");
      try
      {
        String contents = f.get();
        System.out.println(contents);
      } catch(ExecutionException ex)
      {
        ex.getCause().printStackTrace();
      }
    }
  }

  final String fileName;

  public ReadFile(String file) {
    fileName=file;
  }
  public String call() throws Exception {
    String newLine=System.getProperty("line.separator");
    StringBuilder sb=new StringBuilder();
    try(BufferedReader r=new BufferedReader(new FileReader(fileName))) {
      for(;;) {
        String line=r.readLine();
        if(line==null) break;
        sb.append(line).append(newLine);
      }
    }
    return sb.toString();
  }
}