public static Bitmap SavePixels(int x, int y, int w, int h, GL10 gl)
{  
    int b[]=new int[w*h];
    int bt[]=new int[w*h];
    IntBuffer ib=IntBuffer.wrap(b);
    ib.position(0);
    gl.glReadPixels(x, y, w, h, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE, ib);

    /*  remember, that OpenGL bitmap is incompatible with 
        Android bitmap and so, some correction need.
     */   
    for(int i=0; i<h; i++)
    {         
        for(int j=0; j<w; j++)
        {
            int pix=b[i*w+j];
            int pb=(pix>>16)&0xff;
            int pr=(pix<<16)&0x00ff0000;
            int pix1=(pix&0xff00ff00) | pr | pb;
            bt[(h-i-1)*w+j]=pix1;
        }
    }              
    Bitmap sb=Bitmap.createBitmap(bt, w, h, true);
    return sb;
}

public static void SavePNG(int x, int y, int w, int h, String name, GL10 gl)
{
    Bitmap bmp=SavePixels(x,y,w,h,gl);
    try
    {
        FileOutputStream fos=new FileOutputStream("/sdcard/my_app/"+name);
        bmp.compress(CompressFormat.PNG, 100, fos);
        try
        {
            fos.flush();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try
        {
            fos.close();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    catch (FileNotFoundException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }              
}