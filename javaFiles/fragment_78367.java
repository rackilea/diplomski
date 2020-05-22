public interface WithTimeout<Action> {

    default void onTimeout(Action timedOutAction) {
        LogHolder.LOGGER.info("Action {} time out ignored.", timedOutAction);
    }
}
final class LogHolder { // not public
    static final Logger LOGGER = getLogger(WithTimeout.class);
}