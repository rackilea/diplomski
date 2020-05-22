class C1 implements Inflatable, Pump<C1> {
        @Override
        public Pump<? extends Inflatable> getPump() {
            return this; // an instance of C1 which implements Pump<C1>
        }

        @Override
        public int readPressure(C1 thingToInflate) {
            return 0;
        }
    }

    class C2 implements Inflatable {
        @Override
        public Pump<? extends Inflatable> getPump() {
            return new C1(); // again, an instance of C1 which implements Pump<C1>
        }
    }

    public class Preparer {
        public <T extends Inflatable> void inflate(T thingToInflate) {
            int pressure = thingToInflate.getPump().readPressure(thingToInflate);
            // Let's assume that it were possible. What happens if one calls
            // new Preparer().inflate(new C2())?
            // new C2().getPump() returns an instance of C1 which implements Pump<C1>
            // It's readPressure method expects an instance of C1. But T = C2, so
            // the thingToInflate is not an instance of C1. 
            // If the compiler allowed this to happen, the type safety
            // would be violated. 
        }
    }