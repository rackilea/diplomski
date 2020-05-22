// Have the unmodified Enter key cause an event
Action action_ok = new ShortcutAction("Default key", ShortcutAction.KeyCode.ENTER, null);

Action[] actions = new Action[] {action_ok};

public Action[] getActions(Object target, Object sender) {
    if (sender == myPanel)
        return actions;

    return null;
}

/**
 * Handle actions received from keyboard. This simply directs
 * the actions to the same listener methods that are called
 * with ButtonClick events.
 */
public void handleAction(Action action, Object sender, Object target) {
    if (action == action_ok) {
        okHandler();
    }
}