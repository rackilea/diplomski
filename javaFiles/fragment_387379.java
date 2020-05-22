// you need 2 texture IDs now ...
int NB_GL_TEXTURES = 2;
int[] textureIDs = new int[NB_GL_TEXTURES];

// tool function to load a texture to OpenGL
public void loadTexture(GL10 gl, Context context, InputStream is, int GL_id_slot) {

    // decode is to a Bitmap
    Bitmap bitmap;
    try {
        bitmap = BitmapFactory.decodeStream(is);
    } finally {
        try {
            is.close();
        } catch (IOException e) {
        }
    }

    // tell OpenGL what is the current GL texture
    gl.glBindTexture(GL10.GL_TEXTURE_2D, textureIDs[GL_id_slot]);

    // Set up texture filters for current GL texture
    gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
    gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);

    // load the bitmap into current GL texture
    GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);

    // destroy the bitmap
    bitmap.recycle();
}

// Loads the two images into two OpenGL textures
public void loadTextures(GL10 gl, Context context) {

    // generate 2 GL textures IDs => textureIDs[0], textureIDs[1]
    gl.glGenTextures(NB_GL_TEXTURES, textureIDs, 0);

    // load imagen into GL tex of id textureIDs[0]
    InputStream is_bitmap_0 = context.getResources().openRawResource(R.raw.imagen);
    loadTexture(gl, context, is_bitmap_0, 0);

    // load imagen2 into GL tex of id textureIDs[1]
    InputStream is_bitmap_1 = context.getResources().openRawResource(R.raw.imagen2);
    loadTexture(gl, context, is_bitmap_1, 1);
}

public void onSurfaceCreated(GL10 gl, EGLConfig config) {
    // ...

    // Setup the 2 GL Textures, each time the surface is created
    gl.glEnable(GL10.GL_TEXTURE_2D);
    cube.loadTextures(gl, context);

    // ...
}