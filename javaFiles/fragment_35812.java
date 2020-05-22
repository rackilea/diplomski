final User user = data.get(position);   // CHANGE TO FINAL
    holder.textName.setText(user.getName());
    holder.textPrice.setText(user.getPrice());
    holder.textCategory.setText(user.getCategory());
    holder.textQuantity.setText(user.getQuantity()); // ADD THIS LINE
    final UserHolder finalHolder = holder;
    holder.btnEdit.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

            String value1 = finalHolder.textQuantity.getText().toString();
            int a = Integer.parseInt(value1);

            if(a <= 99) {
                int sum = a + 1;

                Log.i("Edit Button Clicked", "**********");
                user.setQuantity(Integer.toString(sum)); // ADD THIS LINE
                finalHolder.textQuantity.setText(Integer.toString(sum));
            }
        }
    });
    holder.btnDelete.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {

                String value2 = finalHolder.textQuantity.getText().toString();
                int a = Integer.parseInt(value2);

                if(a > 0) {
                    int substract = a - 1;
                    Log.i("Delete Button Clicked", "**********");

                     user.setQuantity(Integer.toString(subtract)); // ADD THIS LINE

                 finalHolder.textQuantity.setText(Integer.toString(substract));
                }
        }
    });