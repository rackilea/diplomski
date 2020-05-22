@Override
public void invokeAction(String actionName, Lookup lookup) throws IllegalArgumentException {

if (actionName.equalsIgnoreCase(ActionProvider.COMMAND_RUN)) {
    List<? extends Action> runActions = Utilities.actionsForPath("Actions/Run");
        for (Action action : runActions) {
            action.actionPerformed(null);
        }
}