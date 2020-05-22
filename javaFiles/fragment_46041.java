public class ListAdapter extends ArrayAdapter<String>{
    private Activity context;
    private int[] icon;
    private String[] title;
    private LayoutInflater inflater;
    public ListAdapter(Activity context, int[] icon, String[] title)
    {
      super(context, R.layout.list_item, title);
      this.context = context;
      this.icon = icon;
      this.title = title;
      inflater = LayoutInflater.from(context);
 }
 public View getView(final int position, View view, final ViewGroup parent)
 { 
   view= inflater.inflate(R.layout.list_item, parent, false);
   try
   {
     TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
     ImageView imgIcon = (ImageView) view.findViewById(R.id.imgIcon);
     txtTitle.setText(title[position]);
     imgIcon.setBackgroundResource(icon[position]);
  }
  catch (Exception e)
  { 
    e.printStackTrace();
  }
 finally
 {
    return view;
  }
 }
}