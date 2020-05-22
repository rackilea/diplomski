import java.util.ArrayList;
import java.util.List;

public class CompoundActionExample {

    /**
     * An action is used to do something to an argument.
     */
    interface Action {
        void act( Object argument );
    }

    /**
     * A compound action is an action that acts on an argument
     * by passing the argument to some other actions.
     */
    static class CompoundAction implements Action {
        /**
         * The list of actions that the compound action will perform.  Additional
         * actions can be added using {@link #add(Action)}, and this list is only
         * accessed through the {@link #act(Object)} method.
         */
        private final List<CompoundActionExample.Action> actions;

        /**
         * Create a compound action with the specified list of actions.
         */
        CompoundAction( final List<CompoundActionExample.Action> actions ) {
            this.actions = actions;
        }

        /**
         * Create a compound action with a fresh list of actions.
         */
        CompoundAction() { 
            this( new ArrayList<CompoundActionExample.Action>() );
        }

        /**
         * Add an action to the compound action.
         */
        public void add( CompoundActionExample.Action action ) {
            actions.add( action );
        }

        /**
         * Act on an argument by passing the argument to each of the 
         * compound action's actions.
         */
        public void act( final Object argument) {
            for ( CompoundActionExample.Action action : actions ) {
                action.act( argument );
            }
        }
    }

    public static void main(String[] args) {
        // Some conditions and a list of objects
        final boolean conditionA = true;
        final boolean conditionB = false;
        final Object[] listOfObjects = { "object1", "object2", "object3" };

        // A compound action that encapsulates all the things you want to do
        final CompoundAction compoundAction = new CompoundAction();

        // If conditionA is true, add an action to the compound action that 
        // will perform doA.  conditionA is evaluated exactly once.
        if ( conditionA ) {
            compoundAction.add( new Action() {
                public void act( final Object argument) {
                    System.out.println( "doA("+argument+")" ); // doA( argument );
                }
            });
        }

        // If conditionB is true, add an action to the compound action that
        // will perform doB. conditionB is evaluted exactly once.
        if ( conditionB )  {
            compoundAction.add( new Action() {
                public void act(Object argument) {
                    System.out.println( "doB("+argument+")" ); // doB( argument );
                }
            });
        }

        // For each object, apply the compound action
        for ( final Object o : listOfObjects ) {
            compoundAction.act( o );
        }
    }
}