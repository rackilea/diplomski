public class SlickGame extends BasicGame {

static AppGameContainer appgc;
Rectangle rec;
ShapeWithReference swr;

public SlickGame(String title) {
    super(title);
}

@Override
public void render(GameContainer container, Graphics g) throws SlickException {

}

@Override
public void init(GameContainer container) throws SlickException {
    rec = new Rectangle(0, 0, 64, 64);
    swr = new ShapeWithReference(0, 0, 1, 1);
}

@Override
public void update(GameContainer container, int delta) throws SlickException {
    if(rec.intersects(swr)){
       if(swr.reference instanceof String){
           System.out.println((String)swr.reference);
       }
       else if(swr.reference instanceof Integer){
           System.out.println((Integer)swr.reference);
       }
       else if(swr.reference instanceof Shape){
           Shape temp = (Shape)swr.reference;
           System.out.println(temp.getWidth());
       }
    }
}

public static void main(String[] args) {
    try {

        appgc = new AppGameContainer(new SlickGame("title"));
        appgc.setDisplayMode(800, 600, false);
        appgc.setTargetFrameRate(60);
        appgc.setFullscreen(false);
        appgc.start();

    } catch (SlickException ex) {
        ex.printStackTrace();
    }
}