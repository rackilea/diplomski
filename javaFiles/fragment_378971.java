import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class SimpleInputCoords implements ApplicationListener {
   private OrthographicCamera camera;

   @Override
   public void create() {
      camera = new OrthographicCamera();
      camera.setToOrtho(false, 800, 480);
   }

   @Override
   public void render() {
       int x = Gdx.input.getX();
       int y = Gdx.input.getY();
       int z = 0;
       System.out.println("UnmodifiedYCoord:"+y);

       Vector3 screenCoordinates = new Vector3(x, y, z);
       Vector3 worldCoordinates = camera.unproject(screenCoordinates);
       System.out.println("UnprojectedYCoord:"+worldCoordinates.y);
   }

   @Override
   public void dispose() {
   }

   @Override
   public void resize(int width, int height) {
   }

   @Override
   public void pause() {
   }

   @Override
   public void resume() {
   }