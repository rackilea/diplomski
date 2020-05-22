public class CustomCursorAdapter extends CursorAdapter{

    public int counter = 0;
    private MyAdapterInterface mMyInterface;

    public CustomCursorAdapter(Context context, Cursor c,  MyAdapterInterface myInterface) {

        super(context, c);
        this.context = context;
        this.mMyInterface = myInterface;
    }
    Context context;


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // when the view will be created for first time,
        // we need to tell the adapters, how each item will look
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View retView = inflater.inflate(R.layout.row, parent, false);

        return retView;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        // here we are setting our data
        // that means, take the data from the cursor and put it in views
        TextView textViewPersonName = (TextView) view.findViewById(R.id.item1);
        textViewPersonName.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1))));

        final EditText edit1 = (EditText) view.findViewById(R.id.runningTotal);

        Button plusButton = (Button) view.findViewById(R.id.plusButton);
        plusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                counter++;
                edit1.setText(Integer.toString(counter));
                mMyInterface.updateEditText(/*YOUR VALUE*/);
            }
        });

        Button minusButton = (Button) view.findViewById(R.id.minusButton);
        minusButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                counter--;
                edit1.setText(Integer.toString(counter));
                mMyInterface.updateEditText(/*YOUR VALUE*/);
            }
        });
    }    
}