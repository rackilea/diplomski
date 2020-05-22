@Override
public View getView(int position, View convertView, ViewGroup parent) {

    View row = convertView;
    LayoutHandler layoutHandler;
    if (row == null) {

        LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        row = layoutInflater.inflate(R.layout.row_layout,parent,false);
        layoutHandler = new LayoutHandler();
        layoutHandler.FIRSTNAME = (TextView) row.findViewById(R.id.firstNameText);
        layoutHandler.SURNAME = (TextView) row.findViewById(R.id.surnameText);
        layoutHandler.EMAIL = (TextView) row.findViewById(R.id.emailText);
        layoutHandler.PHONE = (TextView) row.findViewById(R.id.phoneText);
   layoutHandler.ADDINFO = (TextView) row.findViewById(R.id.addInfoText);
   layoutHandler.goButton = (Button) row.findViewById(R.id.goButton);
        row.setTag(layoutHandler);


    }
    else {

        layoutHandler = (LayoutHandler) row.getTag();

    }
    DataProvider dataProvider = (DataProvider)this.getItem(position);
    layoutHandler.FIRSTNAME.setText(dataProvider.getFirst_name());
    layoutHandler.SURNAME.setText(dataProvider.getSurname());
    layoutHandler.EMAIL.setText(dataProvider.getEmail());
    layoutHandler.PHONE.setText(dataProvider.getPhone());
    layoutHandler.ADDINFO.setText(dataProvider.getAdd_info());

    layoutHandler.goButton.setOnClickListener( 
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Start your activity here
                }
            }
    );


    return row;

}