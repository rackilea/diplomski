viewHolder.shoppingName.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

View dailogView =  LayoutInflater.from(mContext).inflate(R.layout.shopping_dialog, null);

        AlertDialog.Builder builder1 = new AlertDialog.Builder(v.getContext());
            builder1.setCancelable(true);

            builder1.setView(dailogView);
            AlertDialog alert = builder1.create();

            EditText text = dailogView.findViewById(R.id.shoppingDialogEditText);
            text.setText("Some Text");


            alert.show();


        }
    });