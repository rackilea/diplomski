Handler handler = new Handler(new Handler.Callback() {
    @Override
    public boolean handleMessage(Message msg) {
        return false;
    }
});
GetYouTubeUserCommentsTask task = new GetYouTubeUserCommentsTask(handler , viewCount);