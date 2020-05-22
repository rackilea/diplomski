mEditText.addTextChangedListener(new TextWatcher() {
        private String current = "";

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!s.toString().equals(current)) {
                annualIncomeEntry.removeTextChangedListener(this);

                String cleanString = s.toString().replaceAll("[$,]", "");

                if (cleanString.length() > 0) {
                    double parsed = Double.parseDouble(cleanString);
                    NumberFormat formatter = NumberFormat.getCurrencyInstance();
                    formatter.setMaximumFractionDigits(0);
                    current = formatter.format(parsed);
                } else {
                    current = cleanString;
                }


                annualIncomeEntry.setText(current);
                annualIncomeEntry.setSelection(current.length());
                annualIncomeEntry.addTextChangedListener(this);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
    });