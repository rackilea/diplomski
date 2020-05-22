private void CalculateTipListener(){
        BtnTip10.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                double amount = Double.parseDouble(etTotalAmount.getText().toString());
                double TipAmount=amount/10;
                tvTipAmount.setText("Tip: $"+TipAmount);
                } catch(NumberFormatException e){
                    Toast.makeText (v.getContext(), "Invalid input!", Toast.LENGTH_SHORT).show();
                    //e.printStackTrace();
                }

            }
    });