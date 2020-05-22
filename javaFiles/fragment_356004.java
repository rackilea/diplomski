public class Flop {

    private Logger log = LoggerFactory.getLogger(Flop.class);


    public void plop() {
        log.debug("Flop debug");
        log.warn("Flop warn");
        log.error("Flop error");
    }
}

public class Main {

    private Logger log = LoggerFactory.getLogger(Main.class);

    public void prout() {
        log.debug("Main debug");
        log.warn("Main warn");
        log.error("Main error");
    }
    public static void main(String[] args) {
        new Main().prout();
        new Flop().plop();
    }
}