public class HistoryListAdapter extends BaseAdapter {

private LayoutInflater inflater;
private List<User> users;
ImageLoader imageLoader = AppController.getInstance().getImageLoader();
public HistoryListAdapter(Activity activity, List<User> users) {
    this.users = users;
    inflater = activity.getLayoutInflater();
}