public class PausableAction extends DelegateAction {

    public static PausableAction pausable(Action wrappedAction){
        PausableAction action = Actions.action(PausableAction.class);
        action.setAction(wrappedAction);
        return action;
    }

    boolean paused = false;

    public void pause (){
        paused = true;
    }

    public void unpause (){
        paused = false;
    }

    protected boolean delegate (float delta){
        if (paused)
            return false;
        return action.act(delta);
    }

    public void restart () {
        super.restart();
        paused = false;
    }
}