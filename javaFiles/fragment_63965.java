public class Customlistadapter extends ArrayAdapter {

private LayoutInflater mInflater;
    Context c;

public Customlistadapter(CustomListView customListView) {
    super(customListView, 0);
    // TODO Auto-generated constructor stub
    this.mInflater = LayoutInflater.from(customListView);  
    c=customListView;
}
public int getCount() {
    return 20; // number of listview rows.
}

public Object getItem(int arg0) {
    return arg0;
}

public long getItemId(int arg0) {
return arg0;
}

public View getView(final int arg0, View arg1, ViewGroup arg2) {
    final ViewHolder vh;
    vh= new ViewHolder();

    if(arg1==null )
     {
        arg1=mInflater.inflate(R.layout.row, arg2,false);
        vh.tv1= (TextView)arg1.findViewById(R.id.textView1);
        vh.tv2= (TextView)arg1.findViewById(R.id.textView2);
     }
    else
    {
     arg1.setTag(vh);
    }
        vh.tv1.setText("hello");    
        vh.tv2.setText("hello");

    return arg1;
}

  static class ViewHolder //use a viewholder for smooth scrolling and performance.
  {
TextView tv1,tv2;

 }
 }