private void incrementDecrementPlate(int unit, int incrementDecrement, int textField) {

    int oldValue;
    if(unit == 0){
        oldValue = (int) poundPlatesToLoad[textField];
    } else {
        oldValue = (int) kilogramPlatesToLoad[textField];
    }

    String incremented;
    String decremented;

    if (oldValue % 2 != 0) {
        incremented = Integer.toString(oldValue + 1);
    } else {
        incremented = Integer.toString(oldValue + 2);
    }

    if (oldValue % 2 != 0) {
        decremented = Integer.toString(oldValue - 1);
    } else if (oldValue != 0) {
        decremented = Integer.toString(oldValue - 2);
    } else {
        decremented = Integer.toString(oldValue);
    }

    switch (unit) {
        case 0:
            if (incrementDecrement == 0) {
                poundTextFieldList.get(textField).setText(incremented);
            } else {
                poundTextFieldList.get(textField).setText(decremented);
            }
            break;
        case 1:
            if (incrementDecrement == 0) {
                kilogramTextFieldList.get(textField).setText(incremented);
            } else {
                kilogramTextFieldList.get(textField).setText(decremented);
            }
            break;
    }
}