//...
actor = event.getListenerActor();
actor.setScale(0.9f);
for (Action action : actor.getActions())
    if (action instanceof PausableAction)
        ((PausableAction)action).pause();
return super.touchDown(event, x, y, pointer, button);