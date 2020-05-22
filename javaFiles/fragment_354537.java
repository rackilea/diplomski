//to added or update the last name to the output(TextView)

joe.setOnClickListener(new View.OnClickListener() {
    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        outputValue = output.getText().toString();

        if (!outputValue.contains("ricele")) {
            output.append(" ricele");
        }
    }
});

//to replace the last name "ricele" to "lee"

lee.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        outputValue = output.getText().toString();

        if (outputValue.contains("ricele")) {
            outputValue = outputValue.replace("ricele", "lee");
            output.setText(outputValue);
        }
    }
});