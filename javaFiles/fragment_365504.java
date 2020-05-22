// this is the run method of the base Thread class
public void run() {
    if (target != null) {
        target.run();
    }
}