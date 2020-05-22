public class CategorySpinnerAdapter extends BaseAdapter {
private List<ItemsDetails> list;
private LayoutInflater inflater;
private Context context;

public CategorySpinnerAdapter(Context context, List<ItemsDetails> list) {
    this.context=context;
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.list = list;
}
@Override
public int getCount() {
    return list.size();
}
@Override
public Object getItem(int position) {
    return list.get(position);
}
@Override
public long getItemId(int position) {
    return position;
}
class MyHolder {
    TextView categoryName;
}


@Override
public View getView(int position, View view, ViewGroup root) {
    if(view == null){
        view = inflater.inflate(R.layout.spinner_item, root, false);
    }
    TextView categoryName = (TextView) view.findViewById(R.id.text_category_name);
    categoryName.setText(list.get(position).getName());
    return view;
}