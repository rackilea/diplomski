package eu.wordnice.thread;
/*** Runa.java ***/

import java.util.concurrent.Callable;

public class Runa implements Callable<Object> {

    private Runnable run = null;

    public Runa(Runnable run) {
        this.run = run;
    }

    public Runa(Thread run) {
        this.run = run;
    }

    public Runa() {}

    public Object call() throws Exception {
        if(run != null) {
            run.run();
        }
        return -1;
    };

}