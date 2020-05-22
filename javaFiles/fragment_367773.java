package stackOverflow.test;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Size;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class CameraSurfaceView extends ViewGroup implements SurfaceHolder.Callback
{

private Size mPreviewSize;
private List<Size> mSupportedPreviewSizes;        
private Context mContext;
private SurfaceView mSurfaceView;
private SurfaceHolder mHolder;
private final String TAG = "CameraSurfaceView";
private Camera mCamera;
private List<String> mSupportedFlashModes;

public CameraSurfaceView(Context context)
{
    super(context);
    mContext = context;
    mCamera = Camera.open();        
    setCamera(mCamera);

    mSurfaceView = new SurfaceView(context);
    addView(mSurfaceView, 0);        
    mHolder = mSurfaceView.getHolder();
    mHolder.addCallback(this);
    mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    mHolder.setKeepScreenOn(true);
}

public CameraSurfaceView(Context context, AttributeSet attrs)
{
    super(context, attrs);
    mContext = context;            
}

public void setSupportedPreviewSizes(List<Size> supportedPreviewSizes)
{
    mSupportedPreviewSizes = supportedPreviewSizes;
}

public Size getPreviewSize()
{
    return mPreviewSize;
}

public void setCamera(Camera camera)
{
    mCamera = camera;
    if (mCamera != null)
    {
        mSupportedPreviewSizes = mCamera.getParameters().getSupportedPreviewSizes();                
        mSupportedFlashModes = mCamera.getParameters().getSupportedFlashModes();
        // Set the camera to Auto Flash mode.
        if (mSupportedFlashModes.contains(Camera.Parameters.FLASH_MODE_AUTO))
        {
            Camera.Parameters parameters = mCamera.getParameters();
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_AUTO);             
            mCamera.setParameters(parameters);
        }                   
    }
    requestLayout();
}

@Override
public void surfaceDestroyed(SurfaceHolder holder)
{
    // Surface will be destroyed when we return, so stop the preview.
    if (mCamera != null)
    {
        mCamera.stopPreview();
    }
}

@Override
public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
{
    // Now that the size is known, set up the camera parameters and begin
    // the preview.
    if (mCamera != null)
    {
        Camera.Parameters parameters = mCamera.getParameters();        
        Size previewSize = getPreviewSize();
        parameters.setPreviewSize(previewSize.width, previewSize.height);                

        mCamera.setParameters(parameters);
        mCamera.startPreview();
    }

}

@Override
public void surfaceCreated(SurfaceHolder holder)
{
    // The Surface has been created, acquire the camera and tell it where
    // to draw.
    try
    {
        if (mCamera != null)
        {
            mCamera.setPreviewDisplay(holder);
        }
    }
    catch (IOException exception)
    {
        Log.e(TAG, "IOException caused by setPreviewDisplay()", exception);
    }
}

@Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
{        
    final int width = resolveSize(getSuggestedMinimumWidth(), widthMeasureSpec);
    final int height = resolveSize(getSuggestedMinimumHeight(), heightMeasureSpec);
    setMeasuredDimension(width, height);

    if (mSupportedPreviewSizes != null)
    {
        mPreviewSize = getOptimalPreviewSize(mSupportedPreviewSizes, width, height);
    }
}

@Override
protected void onLayout(boolean changed, int left, int top, int right, int bottom)
{
    if (changed)
    {                            
        final View cameraView = getChildAt(0);          

        final int width = right - left;
        final int height = bottom - top;

        int previewWidth = width;
        int previewHeight = height;
        if (mPreviewSize != null)
        {
            Display display = ((WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

            switch (display.getRotation())
            {
                case Surface.ROTATION_0:
                    previewWidth = mPreviewSize.height;
                    previewHeight = mPreviewSize.width;
                    mCamera.setDisplayOrientation(90);
                    break;
                case Surface.ROTATION_90:
                    previewWidth = mPreviewSize.width;
                    previewHeight = mPreviewSize.height;
                    break;
                case Surface.ROTATION_180:
                    previewWidth = mPreviewSize.height;
                    previewHeight = mPreviewSize.width;
                    break;
                case Surface.ROTATION_270:
                    previewWidth = mPreviewSize.width;
                    previewHeight = mPreviewSize.height;
                    mCamera.setDisplayOrientation(180);
                    break;
            }                                    
        }

        final int scaledChildHeight = previewHeight * width / previewWidth;

        cameraView.layout(0, height - scaledChildHeight, width, height);

    }
}


private Size getOptimalPreviewSize(List<Size> sizes, int width, int height)
{           
    Size optimalSize = null;                                

    final double ASPECT_TOLERANCE = 0.1;
    double targetRatio = (double) height / width;

    // Try to find a size match which suits the whole screen minus the menu on the left.
    for (Size size : sizes)
    {
        if (size.height != width) continue;
        double ratio = (double) size.width / size.height;
        if (ratio <= targetRatio + ASPECT_TOLERANCE && ratio >= targetRatio - ASPECT_TOLERANCE)
        {
            optimalSize = size;
        }               
    }

    // If we cannot find the one that matches the aspect ratio, ignore the requirement.
    if (optimalSize == null)
    {
        // TODO : Backup in case we don't get a size.
    }

    return optimalSize;
}

public void previewCamera()
{        
    try 
    {           
        mCamera.setPreviewDisplay(mHolder);         
        mCamera.startPreview();                 
    }
    catch(Exception e)
    {
        Log.d(TAG, "Cannot start preview.", e);    
    }
}


/*public void onPreviewFrame(byte[] data, Camera arg1) { 
    Log.d("CameraSurfaceView", "PREVIEW FRAME:"); 
    byte[] pixels = new byte[use_size.width * use_size.height * 3]; ; 
    decodeYUV420SP(pixels, data, use_size.width,  use_size.height);  
    renderer.bindCameraTexture(pixels, use_size.width,  use_size.height); 
}*/ 

void decodeYUV420SP(byte[] rgb, byte[] yuv420sp, int width, int height) {   

    final int frameSize = width * height;   

    for (int j = 0, yp = 0; j < height; j++) {        
        int uvp = frameSize + (j >> 1) * width, u = 0, v = 0;   
        for (int i = 0; i < width; i++, yp++) {   
            int y = (0xff & ((int) yuv420sp[yp])) - 16;   
            if (y < 0){   
                y = 0;  
            } 
            if ((i & 1) == 0) {   
                v = (0xff & yuv420sp[uvp++]) - 128;   
                u = (0xff & yuv420sp[uvp++]) - 128;   
            }   

            int y1192 = 1192 * y;   
            int r = (y1192 + 1634 * v);   
            int g = (y1192 - 833 * v - 400 * u);   
            int b = (y1192 + 2066 * u);   

            if (r < 0){ 
                r = 0;                
            }else if (r > 262143){   
                r = 262143;  
            } 
            if (g < 0){                   
                g = 0;                
            }else if (g > 262143){ 
                g = 262143;  
            } 
            if (b < 0){                   
                b = 0;                
            }else if (b > 262143){ 
                b = 262143;  
            } 
            rgb[yp*3] = (byte) (b << 6); 
            rgb[yp*3 + 1] = (byte) (b >> 2); 
            rgb[yp*3 + 2] = (byte) (b >> 10); 
        }   
    }   
  }   
}