import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;


/**
 * An Answer that resolves differently depending on a specified condition.
 *
 * <p>This implementation is NOT thread safe!</p>
 *
 * @param <T> The result type
 */
public class ConditionalAnswer <T> implements Answer<T> {


    /**
     * Create a new ConditionalAnswer from the specified result suppliers.
     *
     * <p>On instantiation, condition is false</p>
     *
     * @param whenConditionIsFalse  The result to supply when the underlying 
              condition is false
     * @param whenConditionIsTrue The result to supply when the underlying 
              condition is true
     * @param <T> The type of the result to supply
     * @return A new ConditionalAnswer
     */
    public static <T> ConditionalAnswer<T> create (
            final Supplier<T> whenConditionIsFalse,
            final Supplier<T> whenConditionIsTrue) {

        return new ConditionalAnswer<>(
                requireNonNull(whenConditionIsFalse, "whenConditionIsFalse"),
                requireNonNull(whenConditionIsTrue, "whenConditionIsTrue")
        );

    }


    /**
     * Create a Supplier that on execution throws the specified Throwable.
     *
     * <p>If the Throwable turns out to be an unchecked exception it will be
     *  thrown directly, if not it will be wrapped in a RuntimeException</p>
     *
     * @param throwable The throwable
     * @param <T> The type that the Supplier officially provides
     * @return A throwing Supplier
     */
    public static <T> Supplier<T> doThrow (final Throwable throwable) {

        requireNonNull(throwable, "throwable");

        return () -> {

            if (RuntimeException.class.isAssignableFrom(throwable.getClass())) {
                throw (RuntimeException) throwable;
            }

            throw new RuntimeException(throwable);

        };

    }


    boolean conditionMet;
    final Supplier<T> whenConditionIsFalse;
    final Supplier<T> whenConditionIsTrue;



    // Use static factory method instead!
    ConditionalAnswer (
            final Supplier<T> whenConditionIsFalse, 
            final Supplier<T> whenConditionIsTrue) {

        this.whenConditionIsFalse = whenConditionIsFalse;
        this.whenConditionIsTrue = whenConditionIsTrue;

    }



    /**
     * Set condition to true.
     *
     * @throws IllegalStateException If condition has been toggled already
     */
    public void toggle () throws IllegalStateException {

        if (conditionMet) {
            throw new IllegalStateException("Condition can only be toggled once!");
        }

        conditionMet = true;

    }


    /**
     * Wrap the specified answer so that before it executes, this 
     * ConditionalAnswer is toggled.
     *
     * @param answer The ans
     * @return The wrapped Answer
     */
    public Answer<?> toggle (final Answer<?> answer) {

        return invocation -> {
            toggle();
            return answer.answer(invocation);
        };


    }


    @Override
    public T answer (final InvocationOnMock invocation) throws Throwable {

        return conditionMet ? whenConditionIsTrue.get() : whenConditionIsFalse.get();

    }


    /**
     * Test whether the underlying condition is met
     * @return The state of the underlying condition
     */
    public boolean isConditionMet () {
        return conditionMet;
    }


}