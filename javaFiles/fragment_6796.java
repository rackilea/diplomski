import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class Job {
  public String regNo;
  public String gridRef;
  public String gridCopy;

  public String toString() {

    return "Job [teamNo=" + teamNo + ", regNo=" + regNo + ", gridRef="
    + gridRef + "";

  }

  public static void main(String[] args) throws Exception {
    ArrayList<Job> teamNoOne = new ArrayList<Job>();
    // fill your array
    Job job = new Job();
    job.regNo = "123";
    // continue to fill the jobs...
    teamNoOne.add(job);
    BufferedWriter writer = new BufferedWriter(new FileWriter("JOBS-DONE-LOG.txt"));
    System.out.println(teamNoOne.get(0));
    writer.write(teamNoOne.get(0).toString());
    os.close();
  }
}