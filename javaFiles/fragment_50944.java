import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Job {

    char jobId;
    int deadLine;
    int profit;

    public Job(char j, int d, int p) {
        jobId = j;
        deadLine = d;
        profit = p;
    }

    public int getProfit() {
        return profit;
    }
}

public class JobSequencingProblem {

    public void sequence(List<Job> list) {
        list.sort(Comparator.comparing(Job::getProfit));
    }

    public static void main(String args[]) {
        JobSequencingProblem j = new JobSequencingProblem();
        List<Job> list = new ArrayList<>();
        list.add(new Job('a', 2, 100));
        list.add(new Job('b', 1, 19));
        list.add(new Job('c', 2, 27));
        list.add(new Job('d', 1, 25));
        list.add(new Job('e', 3, 15));
        j.sequence(list);
    }
}