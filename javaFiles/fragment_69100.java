@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    ImageView imageView = (ImageView) convertView;
    if (imageView == null) {
        imageView = new ImageView(_activity);
    }

    // Trigger the download of the URL asynchronously into the image view.
    if(_filePaths.get(position).contains(".jpg")) {
        Picasso.with(_activity)
                .load(new File(_filePaths.get(position)))
                .resize(imageWidth, imageWidth)
                .centerCrop()
                .tag(_activity)
                .into(imageView);
    }else  if(_filePaths.get(position).contains(".mp4")){
        VideoRequestHandler videoRequestHandler;
        Picasso picassoInstance;
        videoRequestHandler=new VideoRequestHandler();
        picassoInstance = new Picasso.Builder(_activity.getApplicationContext())
                .addRequestHandler(videoRequestHandler)
                .build();
        picassoInstance
                .load(videoRequestHandler.SCHEME_VIDEO+":"+_filePaths.get(position))
                .resize(imageWidth, imageWidth)
                .centerCrop()
                .tag(_activity)
                .into(imageView);
    }
    return imageView;
}

public static boolean deleteToPhotoAlbum(Integer position) {
    File file = new File(_filePaths.get(position));
    boolean deleted = file.delete();
    return deleted;
}

public class VideoRequestHandler extends RequestHandler {
    public String SCHEME_VIDEO  = "video";
    @Override
    public boolean canHandleRequest(Request data)
    {
        String scheme = data.uri.getScheme();
        return (SCHEME_VIDEO.equals(scheme));
    }

    @Override
    public Result load(Request data, int arg1) throws IOException
    {
        Bitmap bm = ThumbnailUtils.createVideoThumbnail(data.uri.getPath(), MediaStore.Images.Thumbnails.MINI_KIND);
        return new Result(bm, Picasso.LoadedFrom.DISK);
    }
}