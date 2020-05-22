interface ProgressReporter {
    void reportProgress(String message, int step, int total);
}

// Using it:
int step = 0;
for (T t : set) {
    progressReporter.reportProgress("My loop", step, set.size());

    doSomethingWith(t);
}