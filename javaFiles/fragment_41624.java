public class MyAdapter extends BaseAdapter {

public TakeAttend takeAttend;
ArrayList<String> attendList;
LayoutInflater inflater;
//Add new variables Context and your custom SQLiteOpenHelper 
Context context ;
DateBaseHelper DBHelper; // you need to create this class first
public MyAdapter(TakeAttend takeAttend, ArrayList<String> attendList , Context context) {
    // TODO Auto-generated constructor stub
    this.takeAttend = takeAttend;
    this.attendList = attendList;
    inflater = inflater.from(takeAttend);
    this.context = Context;
    DBHelper = new DateBaseHelper(context); // initialize DateBase helper

}

@Override
public int getCount() {
    // TODO Auto-generated method stub
    int size = attendList.size();
    return size;
}
    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(final int position, View v, ViewGroup arg2) {
        // TODO Auto-generated method stub
        v=inflater.inflate(R.layout.attend_layout, null);
        // Get current value
        final String currentAttendent = attendList.Get(position);
        CheckBox box = (CheckBox) v.findViewById(R.id.layout_checkBox);
        // Create TextView
        TextView txt = (TextView) v.findVIewByID(R.id.layout_YourTextViewName) 

       //Setvalue                                                                      
        txt.SetText(currentAttendent);
        box.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked == true){
                   DBHelper.insert(currentAttendent);
                 }
                else{
                   // it depends on how you'd implement DateBaseHelper
                   long ID = DBHelper.GetID(currentAttendent);
                   DBHelper.delete(ID);
                    }

            }
        });


        return v;
    }

    }