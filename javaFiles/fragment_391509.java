@Override
    public void onClick(View v) {

        StringBuilder stringBuilder = new StringBuilder();

        if (BurgatoryCheckBox.isChecked()) { 
          stringBuilder.append(BurgatoryCheckBox.getText().toString() +
                "state is:"+ BurgatoryCheckBox.isChecked() + "\n");
        }

       if(SiennaCheckBox.isChecked()) {
          stringBuilder.append(SiennaCheckBox.getText().toString() +
                "state is:"+ SiennaCheckBox.isChecked() + "\n");
        }

        if(BakersCheckBox.isChecked()) {
          stringBuilder.append(BakersCheckBox.getText().toString() +
                "state is:"+ BakersCheckBox.isChecked() + "\n");
        }

        showTextView.setVisibility(View.VISIBLE);
        showTextView.setText(stringBuilder);

    }
});