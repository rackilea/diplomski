import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

Actor actor = new Image();
actor.addAction(moveTo(10, 20, 0.5f));
RunnableAction run = new RunnableAction();
run.setRunnable(new Runnable() {
    @Override
    public void run() {
        System.out.println("LEEEROOOOOY JEEEEEEENKINS");
    }
});
actor.addAction(sequence(moveTo(200, 100, 2), run));