int taskCount = 10;
List<Double> taskProgress = new ArrayList<>(taskCount);
for (int index = 0; index < taskCount; index++) {
    taskProgress.add(0.0);
}

double overallProgress = 0;
int round = 0;
do {
    round++;
    double sum = 0;
    for (int index = 0; index < taskCount; index++) {
        double progress = taskProgress.get(index);
        progress += Math.random() * 0.1;
        progress = Math.min(progress, 1.0);
        sum += progress;
        taskProgress.set(index, progress);
    }
    overallProgress = sum / (double)taskCount;
    System.out.println("[" + round + "] " + NumberFormat.getPercentInstance().format(overallProgress) + "; " + NumberFormat.getNumberInstance().format(overallProgress));
} while (overallProgress < 1.0);