public class Application4995 {

    public interface State {
        public double getDistance();
        public State getParent();
    }

    public static void main(String[] args) {
       abstract class AbstractState implements State {
            private State parent = null;
            protected double distance = 0;

            public AbstractState(State parent) {
                this.parent = parent;
                if (parent != null) { // Hello !?
                    this.distance = parent.getDistance() + 1;
                }
            }
        }

        class ThisState extends AbstractState {
            State parent;
            public ThisState(State parent) {
                super(parent);
            }


            public State getParent() {
                return parent;
            }

            public double getDistance() {
                return distance;
            }
        }
        ThisState TS1 = new ThisState(null);
        ThisState TS2 = new ThisState(TS1);
        ThisState TS3 = new ThisState(TS2);

        double d1 = TS1.getDistance(); // or int d1 = (int) TS1.getDistance();
        double d2 = TS2.getDistance(); // or int d2 = (int) TS2.getDistance();
        double d3 = TS3.getDistance(); // or int d3 = (int) TS3.getDistance();
   }
}