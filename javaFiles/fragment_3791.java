/**
 * Recurring version of {@link org.jmock.Expectations#onConsecutiveCalls(Action...)}
 * When last action is executed, loops back to first.
 * @param actions Actions to execute.
 * @return An action sequence that will loop through the given actions.
 */
public Action onRecurringConsecutiveCalls(Action...actions) {
    return new RecurringActionSequence(actions);
}
/**
 * Recurring version of {@link org.jmock.lib.action.ActionSequence ActionSequence}
 * When last action is executed, loops back to first.
 * @author AnthonyW
 */
public class RecurringActionSequence extends ActionSequence {
    List<Action> actions;
    Iterator<Action> iterator;

    /**
     * Recurring version of {@link org.jmock.lib.action.ActionSequence#ActionSequence(Action...) ActionSequence}
     * When last action is executed, loops back to first.
     * @param actions Actions to execute.
     */
    public RecurringActionSequence(Action... actions) {
        this.actions = new ArrayList<Action>(Arrays.asList(actions));
        resetIterator();
    }

    @Override
    public Object invoke(Invocation invocation) throws Throwable {
        if (iterator.hasNext()) 
            return iterator.next().invoke(invocation);
        else
            return resetIterator().next().invoke(invocation);
    }

    /**
     * Resets iterator to starting position.
     * @return <code>this.iterator</code> for chain calls.
     */
    private Iterator<Action> resetIterator() {
        this.iterator = this.actions.iterator();
        return this.iterator;
    }
}