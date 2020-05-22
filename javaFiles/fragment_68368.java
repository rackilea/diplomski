public class GdxTest extends ApplicationAdapter {

    public Assets assets;

    @Override
    public void create() {

        assets= new Assets();
    }

    ....

    @Override
    public void dispose() {
       assets.dispose();
    }
}