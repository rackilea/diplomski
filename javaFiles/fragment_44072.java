ArrayAdapter adapter;

@Override
public void onAttach(Context context) {
    adapter = new ArrayAdapter(context,android.R.layout.select_dialog_item,cities);
}