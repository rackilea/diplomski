public class ApplicationAdapter extends ArrayAdapter<ApplicationInfo>  { 
    private List<ApplicationInfo> appsList = null; 
    private Context context; 
    private PackageManager packageManager;
    private List<ApplicationInfo> listOfApp;

    public ApplicationAdapter(Context context, int textViewResourceId, 
            List<ApplicationInfo> appsList) { 
        super(context, textViewResourceId, appsList); 
        this.context = context; 
        this.appsList = appsList;
        this.listOfApp = new ArrayList<ApplicationInfo>(); //Added here
        packageManager = context.getPackageManager();
        listOfApp.addAll(appsList);
    } 

    @Override
    public int getCount() { 
        return ((null != appsList) ? appsList.size() : 0); 
    } 

    @Override
    public ApplicationInfo getItem(int position) { 
        return ((null != appsList) ? appsList.get(position) : null); 
    } 

    @Override
    public long getItemId(int position) { 
        return position; 
    } 

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { 
        View view = convertView; 
        if (null == view) { 
            LayoutInflater layoutInflater = (LayoutInflater) context 
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
            view = layoutInflater.inflate(R.layout.snippet_list_row, null); 
        } 

        ApplicationInfo data = appsList.get(position); 
        if (null != data) { 
            TextView appName = (TextView) view.findViewById(R.id.app_name); 
            TextView packageName = (TextView) view.findViewById(R.id.app_paackage); 
            ImageView iconview = (ImageView) view.findViewById(R.id.app_icon); 

            appName.setText(data.loadLabel(packageManager)); 
            packageName.setText(data.packageName); 
            iconview.setImageDrawable(data.loadIcon(packageManager)); 
        } 
        return view; 
    } 

 // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        appsList.clear();
        if (charText.length() == 0) {
            appsList.addAll(listOfApp);
        } 
        else
        {
            for (ApplicationInfo ai : listOfApp) 
            {
                if (ai.loadLabel(packageManager).toString().toLowerCase(Locale.getDefault()).contains(charText)) 
                {
                    appsList.add(ai);
                }
            }
        }
        notifyDataSetChanged();
    }

}