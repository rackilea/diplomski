public class stackoverflowTest extends Activity {

GLSurfaceView glSurface;
MyRenderer myRenderer;

/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.main);

    glSurface = (GLSurfaceView)findViewById(R.id.glSurfaceView1);

    myRenderer = new MyRenderer();        

    glSurface.setRenderer(myRenderer);

    Square mySquare = new Square();
    myRenderer.addSquareToScene(mySquare);

}
}