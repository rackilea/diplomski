package ru.dima_n.opengl;

import android.opengl.GLSurfaceView;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;


public class MainActivity extends Activity {

    GLSurfaceView glSurfaceView;
    nRender renderer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        glSurfaceView = new GLSurfaceView(this);

        try{    // пытаемся инициализировать OpenGL

            glSurfaceView.setEGLContextClientVersion(2);
            renderer = new nRender(this);
            glSurfaceView.setRenderer(renderer); 
            glSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY); 
            glSurfaceView.requestRender(); )


            Log.e("удачно","3456");

        }catch(RuntimeException e){
            Log.e("error","error");
        } 

        LinearLayout ll = (LinearLayout) this.findViewById(R.id.openGL); // находим наш LinearLayout
        ll.addView(glSurfaceView); // добавляем ему ребенка


    }
}