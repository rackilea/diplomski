ivCall.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (serviceListDates.get(position).getUser_mobile().length() != 0) {
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
            alertDialog.setTitle("NKA SERVICE");
            alertDialog.setMessage("Do you want to Call ?");
            alertDialog.setIcon(R.drawable.call_icon);
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    ((DeliveredServiceOilActivity) mContext).callPhoneNumber
                            (serviceListDates.get(position).getUser_mobile());
                }
            });`enter code here
            alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            alertDialog.show();
        } else
            AlertUtils.SHOW_TOAST(mContext, mContext.getString(R.string.please_add_number));
    }
});