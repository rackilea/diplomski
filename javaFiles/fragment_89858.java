send.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String[] digits = input.getText().toString().split(" ");
            ArrayList<Integer> digitArray = new ArrayList<>();
            for (String digit : digits) {
                if (TextUtils.isDigitsOnly(digit))
                    digitArray.add(Integer.parseInt(digit));
            }
            Collections.sort(digitArray);
            StringBuilder largestPossibleNumber = new StringBuilder();
            for (int i = digitArray.size(); i > 0; i--) {
                largestPossibleNumber.append(digitArray.get(i - 1));
            }
            output.setText(largestPossibleNumber.toString());
        }
    });