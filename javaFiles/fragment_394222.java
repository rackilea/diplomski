volatile boolean stop = false
void run() {
    doComputation();
    if (stop) return;
    doAnotherComputation();
    if (stop) return;
    doMoreComputation();
}