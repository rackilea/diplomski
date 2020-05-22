@Override
public int compare(Task o1, Task o2) {
    if (o1.getLeftEntryTime() == o2.getLeftEntryTime()) {
        return o1.getTimeNeededToBeProcessed - o2.getTimeNeededToBeProcessed();
    } else {
        return o1.getLeftEntryTime() - o2.getLeftEntryTime();
    }
}