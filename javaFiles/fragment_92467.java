if (!inputET.getText().toString().equals("")) {
            if (correctAnswer == Integer.parseInt(inputET.getText()
                    .toString())) {
                inputET.setText("");
                newSum();
            }

        }