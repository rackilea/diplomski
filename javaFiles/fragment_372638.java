public class Burger extends UntypedActor {

    private static int NEEDED_SALAD = 10;
    private static int NEEDED_BREAD = 2;
    private static int NEEDED_BACON = 1;

    private final LoggingAdapter LOG = Logging.getLogger(context().system(), this);
    private int bread, bacon, salad; 

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof Bacon){
            bacon ++;
        }
        else if(message instanceof BreadRoll){
            bread ++;
        }
        else if(message instanceof Salad){
            salad ++;
        }

        if (salad >= NEEDED_SALAD && bread >= NEEDED_BREAD && bacon >= NEEDED_BACON) {
            salad -= NEEDED_SALAD;
            bread -= NEEDED_BREAD;
            bacon -= NEEDED_BACON;

            // and sends message to (or spawns) another actor
        }
    }
}