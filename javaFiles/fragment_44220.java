public void publishLastFive() {
    if (c != null) {         <--- add null check
        System.out.println("publishing last 5");
    } 
}

Command c = null;

public void setCommand(Command c) {
    this.c = c;
}

public void execute() {
    c.execute();
    c = null;                <-- once done executing, set command to null
}