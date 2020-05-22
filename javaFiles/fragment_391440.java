public class JavaScriptInterface {
    private Activity activity;

    public JavaScriptInterface(Activity activiy) {
        this.activity = activiy;
    }

    public void startVideo(String videoAddress){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse(videoAddress), "video/3gpp"); // The Mime type can actually be determined from the file
        activity.startActivity(intent);
    }
}