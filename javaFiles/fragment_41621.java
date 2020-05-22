private EditText clientName;
private EditText clientId;
private EditText clientWallet;
private EditText clientBalance;

void setAddingDialog(){

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    LayoutInflater inflater = getLayoutInflater();

    View dialogView = inflater.inflate(R.layout.dialog_add_new_client, null);
    builder.setView(dialogView)
           .setPositiveButton("add", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String nameValue = clientName.getText().toString().trim();
                    int idValue = Integer.valueOf(clientId.getText().toString().trim());
                    String walletValue = clientWallet.getText().toString().trim();
                    double balanceValue = Double.valueOf(clientBalance.getText().toString().trim());
                    clientListItems.add(new Client(nameValue, idValue, new Wallet(walletValue, balanceValue), R.drawable.ic_launcher_foreground));
                }
            })
           .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                }
            });

    Dialog alertDialog = builder.create();

    clientName = (EditText) dialogView.findViewById(R.id.newClientName);
    clientId = (EditText) dialogView.findViewById(R.id.newClientId);
    clientWallet = (EditText) dialogView.findViewById(R.id.newClientWallet);
    clientBalance = (EditText) dialogView.findViewById(R.id.newClientBalance);

    alertDialog.show();
}