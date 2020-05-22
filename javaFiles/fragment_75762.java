class SpinnerAdapter extends BaseAdapter
{
    ArrayList<Integer> colors;
    Context context;

    public SpinnerAdapter(Context context) 
    {
        this.context=context;
        colors=new ArrayList<Integer>();
        int retrieve []=context.getResources().getIntArray(R.array.androidColors);
        for(int re:retrieve)
        {
            colors.add(re);
        }
    }
    @Override
    public int getCount() 
    {
        return colors.size();
    }
    @Override
    public Object getItem(int arg0) 
    {
            return colors.get(arg0);
    }
    @Override
    public long getItemId(int arg0) 
    {
        return arg0;
    }
    @Override
    public View getView(int pos, View view, ViewGroup parent) 
    {
        LayoutInflater inflater=LayoutInflater.from(context);
        view=inflater.inflate(android.R.layout.simple_spinner_dropdown_item, null);
        TextView txv=(TextView)view.findViewById(android.R.id.text1);
        txv.setBackgroundColor(colors.get(pos));
        txv.setTextSize(20f);
        txv.setText("Text  "+pos);
        return view;
    }

}