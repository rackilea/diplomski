builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            if (s.equals("Amount")){
                v = et.getText().toString();
                amount = Integer.parseInt(v);
                tv.setText(String.valueOf(amount));
            }
        }
});