private LayoutInflater myInflater;
private String shopList[];

public ShopListAdapter(Context context, String shopList[]) {
    myInflater = LayoutInflater.from(context);
    this.shopList = shopList;
}

static class ViewHolder {
    TextView tvTitle;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;

    if (convertView == null) {
        convertView = myInflater.inflate(R.layout.list_item, null);
        holder = new ViewHolder();

        holder.tvTitle = (TextView) convertView.findViewById(R.id.rowText);
        convertView.setTag(holder);
    } else {
        holder = (ViewHolder) convertView.getTag();
    }

    holder.tvTitle.setText(shopList[position]);

    return convertView;
}