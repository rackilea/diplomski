public class ContactsAdapter extends BaseAdapter implements Filterable{

private Context context;
private List<Map<String, Object>> originalData;
private List<Map<String, Object>> suggestionData = new ArrayList<>();
private Filter filter = new CustomFilter();

public ContactsAdapter(Context context, List<Map<String, Object>> data) {
    super();
    this.context = context;
    this.originalData = data;
}

@Override
public int getCount() {
    return suggestionData.size();
}

@Override
public Object getItem(int position) {
    return suggestionData.get(position).get("name").toString();
}

@Override
public long getItemId(int position) {
    return position;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {

    ViewHolder holder;

    if (convertView == null) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.single_contact, parent, false);

        holder = new ViewHolder();
        holder.cName = (TextView) convertView.findViewById(R.id.tv_ContactName);
        holder.cThumb = (ImageView) convertView.findViewById(R.id.iv_contact_thumbnail);

        convertView.setTag(holder);
    } else {
        holder = (ViewHolder) convertView.getTag();
    }

    holder.cName.setText(suggestionData.get(position).get("name").toString());
    holder.cThumb.setImageBitmap((Bitmap) suggestionData.get(position).get("thumbnail"));

    return convertView;

}

@Override
public Filter getFilter() {
    return filter;
}


private static class ViewHolder {
    TextView cName;
    ImageView cThumb;
}

/**
 * Our Custom Filter Class.
 */
private class CustomFilter extends Filter {
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        suggestionData.clear();

        if (originalData != null && constraint != null) { // Check if the Original List and Constraint aren't null.
            for (int i = 0; i < originalData.size(); i++) {
                if (Pattern.compile(Pattern.quote(constraint.toString()),
                        Pattern.CASE_INSENSITIVE).matcher
                        (originalData.get(i).get("name").toString()).find()) { // Compare item in original list if it contains constraints.
                    suggestionData.add(originalData.get(i)); // If TRUE add item in Suggestions.
                }
            }
        }
        FilterResults results = new FilterResults(); // Create new Filter Results and return this to publishResults;
        results.values = suggestionData;
        results.count = suggestionData.size();

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        if (results.count > 0) {
            notifyDataSetChanged();
        } else {
            notifyDataSetInvalidated();
        }
    }
}
}