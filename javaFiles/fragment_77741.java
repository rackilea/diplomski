LayoutInflater inflater = this.getLayoutInflater();
View view = inflater.inflate(R.layout.login_laylout, null, false);

    // Inflate and set the layout for the dialog
    // Pass null as the parent view because its going in the dialog layout
    builder.setView(view)
    .setPositiveButton("Login", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            Dialog f = (Dialog) dialog;

            EditText txtLoginUserPhoneNumber = (EditText) view.findViewById(R.id.txt_LoginUserPhoneNumber);
            EditText txtLoginUserPW = (EditText) view.findViewById(R.id.txt_LoginUserPW);

           ...
        }
    })