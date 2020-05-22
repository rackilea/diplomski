public class nRender implements GLSurfaceView.Renderer
{

    private Context cnx;

    public nRender(Context context) {
        this.cnx = context;
    }

    public void onDrawFrame(GL10 glUnused) { 

        Random rnd = new Random();

        GLES20.glClearColor(((float)rnd.nextInt(2)/2.0f), ((float)rnd.nextInt(2)/2.0f), ((float)rnd.nextInt(2)/2.0f), 1.0f);
        Log.e("test","color");
        GLES20.glClear( GLES20.GL_COLOR_BUFFER_BIT ); 
    }

    public void onSurfaceChanged(GL10 glUnused, int width, int height) { 

        GLES20.glViewport(0, 0, width, height);

    }

    public void onSurfaceCreated(GL10 glUnused, EGLConfig config) { 

    }
}