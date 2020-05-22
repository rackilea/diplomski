exportText = resultText.getText().toString().trim(); //.trim() removes space before and after text
    if (!exportText.isEmpty()) {
         openDialog();
    } else {
        Toast.makeText(SpeechToText.this, "Input field empty...", Toast.LENGTH_SHORT).show();
    }