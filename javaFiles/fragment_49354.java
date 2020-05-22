@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.tab1expense, container, false);
    btnEx = (Button)rootView.findViewById(R.id.btnEx);
    btnEx.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(button.this).inflate(R.layout.add_ex, null);
                AlertDialog.Builder add = new AlertDialog.Builder(tab1Expenses.this.getActivity());
                add.setView(view);
                add.setCancelable(true)
                    .setTitle("Enter Expense:")
                    .setMessage("Expense Name:")
                    .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                Dialog dialog = add.create();
                dialog.show();
            }
        });
    return rootView;
}