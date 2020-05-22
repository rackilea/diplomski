import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class VBOTest
{
    public final static void main(String[] args)
    {
        int width = 1280;
        int height = 720;

        try
        {
            Display.setTitle("VBO Test");
            Display.setDisplayMode(new DisplayMode(width, height));

            Display.create();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();

            System.exit(0);
        }

        /*
         * Initialize OpenGL States
         */

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();

        glOrtho(0f, width, height, 0f, -1f, 1f);

        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();

        glEnable(GL_DEPTH_TEST);
        glDepthFunc(GL_LEQUAL);

        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

        glEnable(GL_CULL_FACE);
        glCullFace(GL_BACK);

        glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);

        /*
         * Creating the Vertex & Color VBO
         */

        final int VERTEX_SIZE = 3; // X, Y, Z,
        final int COLOR_SIZE = 4; // R, G, B, A,

        int vertices = 6;

        int vbo_vertex_handle;
        int vbo_color_handle;

        FloatBuffer vertex_data = BufferUtils.createFloatBuffer(vertices * VERTEX_SIZE);

        float half_width = 200f;
        float half_height = 200f;

        vertex_data.put(new float[] { -half_width, -half_height, 0f, });
        vertex_data.put(new float[] { -half_width, half_height, 0f, });
        vertex_data.put(new float[] { half_width, -half_height, 0f, });

        vertex_data.put(new float[] { half_width, half_height, 0f, });
        vertex_data.put(new float[] { half_width, -half_height, 0f, });
        vertex_data.put(new float[] { -half_width, half_height, 0f, });

        vertex_data.flip();

        FloatBuffer color_data = BufferUtils.createFloatBuffer(vertices * COLOR_SIZE);

        color_data.put(new float[] { 1f, 0f, 0f, 1f, });
        color_data.put(new float[] { 1f, 0f, 1f, 1f, });
        color_data.put(new float[] { 1f, 1f, 0f, 1f, });

        color_data.put(new float[] { 0f, 1f, 0f, 1f, });
        color_data.put(new float[] { 1f, 1f, 0f, 1f, });
        color_data.put(new float[] { 1f, 0f, 1f, 1f, });

        color_data.flip();

        vbo_vertex_handle = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo_vertex_handle);
        glBufferData(GL_ARRAY_BUFFER, vertex_data, GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER, 0);

        vbo_color_handle = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo_color_handle);
        glBufferData(GL_ARRAY_BUFFER, color_data, GL_STATIC_DRAW);
        glBindBuffer(GL_ARRAY_BUFFER, 0);

        /*
         * Main Rendering Loop
         */

        boolean running = true;

        while (running)
        {
            running = (!Display.isCloseRequested() && !Keyboard.isKeyDown(Keyboard.KEY_ESCAPE));

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glLoadIdentity();

            glPushMatrix();
            {
                glTranslatef(width / 2f, height / 2f, 0f);

                glBindBuffer(GL_ARRAY_BUFFER, vbo_vertex_handle);
                glVertexPointer(VERTEX_SIZE, GL_FLOAT, 0, 0l);
                glBindBuffer(GL_ARRAY_BUFFER, 0);

                glBindBuffer(GL_ARRAY_BUFFER, vbo_color_handle);
                glColorPointer(COLOR_SIZE, GL_FLOAT, 0, 0l);
                glBindBuffer(GL_ARRAY_BUFFER, 0);

                glEnableClientState(GL_VERTEX_ARRAY);
                glEnableClientState(GL_COLOR_ARRAY);

                glDrawArrays(GL_TRIANGLES, 0, vertices);

                glDisableClientState(GL_COLOR_ARRAY);
                glDisableClientState(GL_VERTEX_ARRAY);
            }
            glPopMatrix();

            glFlush();

            Display.sync(60);
            Display.update();
        }

        /*
         * Dispose Elements
         */

        glDeleteBuffers(vbo_vertex_handle);
        glDeleteBuffers(vbo_color_handle);

        Display.destroy();

        System.exit(0);
    }
}