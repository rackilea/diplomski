public class AAdapter  extends BaseAdapter implements View.OnClickListener {

    Context context;
    private List<Route> routes;
    Holder holder;
    private static LayoutInflater inflater=null;
    ListListener listListener;

    public AAdapter(Context context, List<Route> names,ListListener listListener) {
       this.routes=names;
        this.context=context;
        this.listListener=listListener;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void onClick(View view) {
        listListener.clickListItem((Integer)view.getTag());
    }

    private class Holder
    {
        TextView tv;
    }

    @Override
    public Route getItem(int position) {
        return routes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return routes.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            holder=new Holder();

            convertView=inflater.inflate(R.layout.custom_layout,null);

            holder.tv=(TextView)convertView.findViewById(R.id.textView);
            holder.tv.setOnClickListener(this);
            convertView.setTag(holder);

        }else {
            holder=(Holder)convertView.getTag();
        }

        holder.tv.setText(routes.get(position).getStudentName());
        holder.tv.setTag(position);

        if (!routes.get(position).colorRed){
            holder.tv.setBackgroundColor(Color.GREEN);
        }else {
            holder.tv.setBackgroundColor(Color.RED);
        }
        return convertView;
    }
}