package managers;

import java.util.HashMap;
import java.util.Map;

import org.mt4j.MTApplication;

import processing.core.PImage;




public class ImageManager {

private static ImageManager mImageManager = null;

protected MTApplication mApp;
protected Map< String, PImage > mImages;

protected PImage mTempImg;

private ImageManager( MTApplication app ) {
    mApp = app;
    mImages = new HashMap< String, PImage >();
}

public static synchronized ImageManager getInstance( MTApplication app ) {
    if( mImageManager == null ) {
        mImageManager = new ImageManager( app );
    }

    return mImageManager;
}

/**
 * Load or retrieve img in memory
 * 
 * @param path Path to the image
 * @return <PImage> the image
 */
public PImage getImage( String path ) {
    // Search for image
    if( mImages.containsKey( path ) ) {
        System.out.println( "ImageManager::getImage : image found !" );
        mTempImg = mImages.get( path );
    } 
    else {
        System.out.println( "ImageManager::getImage : image not found, loading" );
        mTempImg = mApp.loadImage( path );
        mImages.put( path, mTempImg );
    }

    return mTempImg;
}
}