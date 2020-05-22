alertBuilder.setCancelable(true).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
        inputName = String.valueOf(userInput.getText());
        if(inputName != "" && inputName != null)
           saveToTxtFile(exportText,inputName);
        else
           //Toast an error here
    }
});