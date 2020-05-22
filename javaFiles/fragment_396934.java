public class IndividualsAdaptor extends ArrayAdapter {
protected Context mContext;
// Code for Custom Filter.
protected List mBackupList = new ArrayList();

public IndividualsAdaptor(Context context, List status) {
    super(context, R.layout.t3, status);
    mContext = context;
    // Code for Custom Filter.
    mBackupList.addAll(status);
}

@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    ViewHolder holder;

    if (android.os.Build.VERSION.SDK_INT > 9) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    if (convertView == null) {
        convertView = LayoutInflater.from(mContext).inflate(R.layout.t3, null);
        holder = new ViewHolder();
        holder.usernameHomepage = (TextView) convertView.findViewById(R.id.fname);
        holder.statusHomepage = (TextView) convertView.findViewById(R.id.lname);
        holder.pposition = (TextView) convertView.findViewById(R.id.idposition);
        holder.orgName = (TextView) convertView.findViewById(R.id.organizationname);
        holder.logo = (ImageView) convertView.findViewById(R.id.imageView);
        convertView.setTag(holder);
    } else {
        holder = (ViewHolder) convertView.getTag();
    }

    ParseObject statusObject = (ParseObject) getItem(position);
    // title
    String username = statusObject.getString("firstname");
    holder.usernameHomepage.setText(username);
    // content
    String status = statusObject.getString("lastname");
    holder.statusHomepage.setText(status);
    // content
    String positions = statusObject.getString("position");
    holder.pposition.setText(positions);
    // content
    String org = statusObject.getString("organizationName");
    holder.orgName.setText(org);
    // logo
    URL url = null;
    Bitmap bmp = null;
    try {
        url = new URL("img hosting location" + statusObject.getString("image"));
        bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
    } catch (MalformedURLException e) {
    }catch (IOException e) {
    }
    holder.logo.setImageBitmap(bmp);
    Picasso.with(mContext)
            .load(String.valueOf(url))
            .into(((ImageView) convertView
                    .findViewById(R.id.imageView)));

    return convertView;
}

public static class ViewHolder {
    TextView usernameHomepage;
    TextView statusHomepage;
    TextView orgName;
    TextView pposition;
    ImageView logo;
}

// Code for Custom Filter.
@Override
public Filter getFilter() {return new Filter(){
    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        String queryString = charSequence.toString().toLowerCase();
        List<ParseObject> filteredList = new ArrayList<>();
        ParseObject tmpItem;
        String tmpUsername, tmpStatus, tmpPositions, tmpOrg;
        for(int i=0; i<mBackupList.size(); i++){
            tmpItem = (ParseObject) mBackupList.get(i);
            tmpUsername = tmpItem.getString("firstname").toLowerCase();
            tmpStatus = tmpItem.getString("lastname").toLowerCase();
            tmpPositions = tmpItem.getString("position").toLowerCase();
            tmpOrg = tmpItem.getString("organizationName").toLowerCase();
            // The matching condition
            if(tmpUsername.contains(queryString)||tmpStatus.contains(queryString)||
                    tmpPositions.contains(queryString)||tmpOrg.contains(queryString)){
                filteredList.add(tmpItem);
            }
        }
        FilterResults filterResults = new FilterResults();
        filterResults.count = filteredList.size();
        filterResults.values = filteredList;
        return filterResults;
    }
    @Override
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        clear();
        addAll((List<ParseObject>) filterResults.values);
    }
};}

public void updateBackupList(List newList){
    mBackupList.clear();
    mBackupList.addAll(newList);
}
}