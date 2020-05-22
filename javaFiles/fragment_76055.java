import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.opengles.GL10;

// in code.

EGL10 egl = (EGL10)EGLContext.getEGL(); 
GL10 gl = (GL10)egl.eglGetCurrentContext().getGL();