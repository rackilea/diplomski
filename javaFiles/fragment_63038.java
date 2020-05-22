public class Scene<HandlerType extends Handler> {
    protected HandlerType handler;

    public Scene(HandlerType handler){
        this.handler = handler;
    }

    public void render(Graphics g){
        handler.render(g);
    }
}