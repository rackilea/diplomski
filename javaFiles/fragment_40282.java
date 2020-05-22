public class MyListAdapter extends ArrayAdapter<Transaction> {

    private static final String TAG = MyListAdapter.class.getSimpleName();


    public MyListAdapter(Context context, ArrayList<Transaction> transactionList) {
        super(context, 0, transactionList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Transaction transactionData = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout_2, parent, false);
        }

        TextView textView1 = (TextView) convertView.findViewById(R.id.textView1);
        TextView textView2 = (TextView) convertView.findViewById(R.id.textView2);


        String debtor = transactionData.getDebtor();
        String receiver = transactionData.getReceiver();
        textView1.setText(debtor);
        textView2.setText(receiver);

        return convertView;
    }
}