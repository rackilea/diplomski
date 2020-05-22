public class UploadableImage
{
  private static final int MAX_WIDTH  = 1280;
  private static final int MAX_HEIGHT = 1280;

  private Uri              mUri;

  private String           mImageName;

  private Context          mContext;

  public UploadableImage( Context context )
  {
    mContext = context;

    generateFilename();
  }

  public UploadableImage( Context context, Uri uri )
  {
    mContext = context;
    mUri = uri;

    generateFilename();
  }

  // TODO Generate...
  private void generateFilename()
  {
    mImageName = UUID.randomUUID().toString() + ".jpg";
  }

  public void setUri( Uri uri )
  {
    mUri = uri;
  }

  public Bitmap toBitmap()
  {
    try
    {
      InputStream input = mContext.getContentResolver().openInputStream( mUri );

      BitmapFactory.Options readOptions = new BitmapFactory.Options();
      readOptions.inJustDecodeBounds = true;

      BitmapFactory.decodeStream( input, null, readOptions );

      input.close();

      // Raw height and width of image
      final int height = readOptions.outHeight;
      final int width = readOptions.outWidth;

      int inSampleSize = 1;

      if( height > MAX_HEIGHT || width > MAX_WIDTH )
      {
        if( width > height )
        {
          float result = ( float )height / ( float )MAX_HEIGHT;

          inSampleSize = ( int )FloatMath.ceil( result );
        }
        else
        {
          float result = ( float )width / ( float )MAX_WIDTH;

          inSampleSize = ( int )FloatMath.ceil( result );
        }
      }

      return toBitmap( inSampleSize );
    }
    catch( Exception e )
    {
      e.printStackTrace();
    }

    return null;
  }

  public Bitmap toBitmap( int sampleSize )
  {
    try
    {
      InputStream input = mContext.getContentResolver().openInputStream( mUri );

      input = mContext.getContentResolver().openInputStream( mUri );

      // Decode bitmap with inSampleSize set
      BitmapFactory.Options scaleOptions = new BitmapFactory.Options();

      scaleOptions.inJustDecodeBounds = false;
      scaleOptions.inSampleSize = sampleSize;

      Bitmap scaledBitmap = BitmapFactory.decodeStream( input, null, scaleOptions );

      input.close();

      return scaledBitmap;
    }
    catch( Exception e )
    {
      e.printStackTrace();
    }

    return null;
  }

  public KnownSizeInputStream toMimeStream()
  {
    Bitmap scaledBitmap = toBitmap();

    ByteArrayOutputStream stream = new ByteArrayOutputStream();

    scaledBitmap.compress( Bitmap.CompressFormat.JPEG, 95, stream );

    byte[] byteArray = stream.toByteArray();

    return new KnownSizeInputStream( new ByteArrayInputStream( byteArray ), byteArray.length, "image/jpg", mImageName );
  }

  public String toString()
  {
    return "UploadableImage, Uri: " + mUri;
  }
}