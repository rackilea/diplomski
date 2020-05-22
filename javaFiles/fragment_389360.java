public class SimpleArray {
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int numberOfProcesses;
    System.out.print("Processes: ");
    numberOfProcesses = input.nextInt();

    String[] process = new String[numberOfProcesses];
    int[] CPUburst = new int[numberOfProcesses];
    int[] priority = new int[numberOfProcesses];

    int[] waitingTime = new int[numberOfProcesses];

    for (int i = 0; i < numberOfProcesses; i++) {
        System.out.print("Process>> ");
        process[i] = input.next();

        System.out.print("Enter the CPU Burst>> ");
        CPUburst[i] = input.nextInt();

        System.out.print("Enter the Priority>> ");
        priority[i] = input.nextInt();
    }

    System.out.println(" | Process | CPU Burst | Priority | Waiting Time | ");

    int temp = 0;
    for (int k = 0; k < numberOfProcesses; k++) {

        if (k > 0)
            waitingTime[k] = waitingTime[k-1] + CPUburst[k-1];

        System.out.println(" |    " + process[k] + "    |    " + CPUburst[k] + "      |    " + priority[k] + "     |    " + waitingTime[k] + "        | ");

    }
    double averageWaitTime = 0;
    if (numberOfProcesses > 0)
        averageWaitTime = (double)waitingTime[numberOfProcesses-1] / (numberOfProcesses);
    System.out.println("Average wait time = "+averageWaitTime);
}
}