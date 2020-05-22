public class FavouriteAdapter extends BaseAdapter{

Activity context;
ArrayList<String> f_name,f_number;
TextView tf_name,tf_number,main_letter;
int i;

FavouriteAdapter(Activity context, ArrayList<String> fav_name, ArrayList<String> fav_number){
    this.context=context;
    this.f_name=fav_name;
    this.f_number=fav_number;
}

@Override
public int getCount() {
    return f_name.size();
}

@Override
public Object getItem(int i) {
    return null;
}

@Override
public long getItemId(int i) {

    return i;
}

@Override
public View getView(final int position, View view, ViewGroup viewGroup) {

    LayoutInflater l=context.getLayoutInflater();
    View row=l.inflate(R.layout.favourite_adapter_layout,null,true);


    main_letter=(TextView)row.findViewById(R.id.main_letter);
    tf_name=(TextView) row.findViewById(R.id.favName);
    tf_number=(TextView)row.findViewById(R.id.favNumber);

    try {
                tf_name.setText(f_name.get(position));
                tf_number.setText(f_number.get(position));
                if (!f_name.get(position).isEmpty()) {
                    String init = f_name.get(position).substring(0, 1);
                    main_letter.setText(init);
                }}
    catch (Exception e){
        System.out.println(e);
    }
    return row;
}
 }