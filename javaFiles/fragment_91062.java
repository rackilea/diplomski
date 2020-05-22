class imageCheckBoxAdapter extends ArrayAdapter<String> implements View.onClickListener
{
    private final Context context;
    private final ArrayList<String> values;
    private final Map< String, SmbFile> obj;
    private ArrayList<Boolean> checks=new ArrayList<Boolean>();

    public imageCheckBoxAdapter(Context context,ArrayList<String> values,Map< String, SmbFile>obj) 
    {
        super(context, R.layout.row_checkbox, values);
        this.context = context;
        this.values = values;
        this.obj=obj;

        for (int i = 0; i < values.size(); i++) {
            checks.add(i, false);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_checkbox, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.text1_check);
        CheckBox chk = (CheckBox) rowView.findViewById(R.id.checkBox1);
        textView.setText(values.get(position));
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon_image_check);
        try
        {
            if((obj.get(values.get(position)).isFile()))
            {
                imageView.setImageResource(R.drawable.view_file_icon);
            }
            else
            {
                imageView.setImageResource(R.drawable.view_folder_icon);
            }
        }
        catch (SmbException e) 
        {
            Toast.makeText(context,"Network error",Toast.LENGTH_SHORT).show();
            Log.d("id1", "error1");
            e.printStackTrace();
        }

        chk.setTag(Integer.valueOf(position));

        // Set a listener for the checkbox
        chk.setOnClickListener(this);

        //Sets the state of CB, since we have the list of checked CB
        chk.setChecked(checks.get(position));

        return rowView;
    }

    @Override
    public void onClick(View view) {
        Integer index = (Integer)view.getTag();
        boolean state = checks.get(index.intValue());

        checks.set(index.intValue(), !state);
    }
}