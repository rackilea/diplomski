public class Post extends Fragment implements OnDownloadImageListener {
...
private void saveBitmap(String userName, String key){
    DownloadImage downloadImage = new DownloadImage();
    final Bitmap[] bitmap = new Bitmap[1];
    final String url = "https://graph.facebook.com/" + key + "/picture?  type=large";

    downloadImage.execute(url);
    downloadImage.setOnDownloadImageListener(this);
    //**FIGURE 1**
}

@Override
public void onDownloadComplete(Bitmap bmap) { 
    bitmap[0] = bmap; //fixed the variable error
}