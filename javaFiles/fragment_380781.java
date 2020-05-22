public class HistoryListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<User> users;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    public HistoryListAdapter(List<User> users) {
        this.users = users;
    }