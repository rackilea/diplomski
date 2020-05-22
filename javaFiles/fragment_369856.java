if(!TextUtils.isEmpty(displayHandler.getDisplay().getText().toString())) {

    displayHandler.addToSecondDisplay(buttonHandler.getOperandSpinner().getSelectedItem().toString(),
                    Float.parseFloat(displayHandler.getDisplay().getText().toString()), "");

    calculate();

}