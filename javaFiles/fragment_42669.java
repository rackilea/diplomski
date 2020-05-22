final Actor actor = // ... initialize your actor;
final Action action = Actions.forever(Actions.rotateBy(360f, 3f, Interpolation.bounceOut));
actor.addAction(action);

actor.addListener(new ClickListener() {
    @Override
    public void clicked(InputEvent event, float x, float y) {
        Array<Action> actions = actor.getActions();
        if (actions.contains(action, true)) {
            // removing an action with Actor#removeAction(Action) method will reset the action,
            // we don't want that, so we delete it directly from the actions array
            actions.removeValue(action, true);
        } else {
            actor.addAction(action);
        }

    }
});