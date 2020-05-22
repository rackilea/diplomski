final LayoutInflater inflater = getActivity().getLayoutInflater();
// Inflate and set the layout for the dialog
// Pass null as the parent view because its going in the dialog layout
View dialogView = inflater.inflate(R.layout.connection_dialog, null);

final EditText editHost = (EditText)dialogView.findViewById(R.id.dialog_host);
final EditText editUser = (EditText)dialogView.findViewById(R.id.dialog_user);
final EditText editPassword = (EditText)dialogView.findViewById(R.id.dialog_password);

builder.setView(dialogView)
        // Add action buttons
        .setPositiveButton(R.string.connect, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                String host = editHost.getText().toString();
                String user = editUser.getText().toString();
                String pass = editPassword.getText().toString();

                mListener.onDialogPositiveClick(host, user, pass);
            }
        })
        // set null to dismiss dialog
        .setNegativeButton(R.string.abort, null);
return builder.create();