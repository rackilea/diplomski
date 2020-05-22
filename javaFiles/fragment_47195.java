TextWatcher updateData(String editText, @NonNull DrinkDataViewHolder holder) {
    return new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            Drink drink = getDrink(holder.mTvDrinkName.getText().toString());
            if(drink == null) return;
            switch (editText) {
                switch (editText) {
                    case NAME:
                        drinkList.get(drinkList.indexOf(drink)).getDrinkDetails().drink_name = charSequence.toString();
                        break;
                    case SUGAR:
                        drinkList.get(drinkList.indexOf(drink)).getDrinkDetails().sugar = charSequence.toString();
                        break;
                    case ICE:
                        drinkList.get(drinkList.indexOf(drink)).getDrinkDetails().ice = charSequence.toString();
                        break;
                }
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}

private Drink getDrink(String name) {
    for (Drink drink : drinkList) {
        if (drink.getDrinkDetails().drink_name.equalsIgnoreCase(name))
            return drink;
    }
    return null;
}