Action action = component.getActionMap().get("...");

if (action != null)
{
    ActionEvent ae = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "");
    action.actionPerformed( ae );
}