send.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String enteredText = input.getText().toString();
            ArrayList<Integer> digitArray = new ArrayList<>();
            for(int i = 0 ; i< enteredText.length(); i++) {
                if (TextUtils.isDigitsOnly(String.valueOf(enteredText.charAt(i))))
                    digitArray.add(Integer.parseInt(String.valueOf(enteredText.charAt(i))));
            }
            Collections.sort(digitArray);
            StringBuilder largestPossibleNumber = new StringBuilder();
            for (int i = digitArray.size(); i > 0; i--) {
                largestPossibleNumber.append(digitArray.get(i - 1));
            }
            output.setText(largestPossibleNumber.toString());
        }
    });