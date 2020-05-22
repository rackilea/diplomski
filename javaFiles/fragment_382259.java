int winX = ...  //the x coordinate of the Click, given Parameter
int winY = ... //the y Coordinate of the Click, given Parameter
FloatBuffer winZ = BufferUtils.createFloatBuffer(1); //the x coordinate of the click, will be calculated
FloatBuffer pos = BufferUtils.createFloatBuffer(3); // the final position of the click
FloatBuffer modelview = BufferUtils.createFloatBuffer(16); 
FloatBuffer projection = BufferUtils.createFloatBuffer(16); 
IntBuffer viewport = BufferUtils.createIntBuffer(16); 

GL11.glGetInteger(GL11.GL_VIEWPORT, viewport);
GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, modelview);
GL11.glGetFloat(GL11.GL_PROJECTIONMATRIX, projection);

GL11.glReadPixels(winX, winY, 1,1, GL11._GL_DEPTH_COMPONENT, GL11.GL_FLOAT, winZ) //calculate the Z Coordinate of the Click
GLU.gluUnProject((float)(winX), (float)(winY), (float)(winZ.get(0)), modelview, projection, viewport, pos); //Calculating the 3D Position of the click, saved in pos