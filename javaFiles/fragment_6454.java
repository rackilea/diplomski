public class MyAdapter extends BaseAdapter {

    private ArrayList<Container> containers;
    private Context              context;

    public int getCount() {
        return containers.size();
    }

    public Object getItem(final int position) {
        return containers.get(position);
    }

    public long getItemId(final int position) {
        return position;
    }

    public View getView(final int position, final View contentView, final ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        Container container = containers.get(position);
        if (container != null) {
           // Do your image thing here
        }

        return imageView;
    }

    public MyAdapter(final Context context, final ArrayList<Container> containers, final String appName) {
        this.context = context;
        this.containers = containers;
    }
}