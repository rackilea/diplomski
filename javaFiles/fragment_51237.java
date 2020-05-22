public void onSurfaceChanged(GL10 gl, int width, int height) {
    gl.glViewport(0, 0, width, height);     
    gl.glMatrixMode(GL10.GL_PROJECTION);
    gl.glLoadIdentity(); //make sure to reset before glOrthof
    gl.glOrthof(0, 320f, 480f, 0, 0, 1);
}