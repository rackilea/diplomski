public void setInputType(int inputType) {
    if((inputType & TextArea.NUMERIC) == TextArea.NUMERIC || 
            (inputType & TextArea.PHONENUMBER) == TextArea.PHONENUMBER) {
        setInputModeOrder(new String []{NUMBERS_MODE});
        return;
    }
    if((inputType & TextArea.DECIMAL) == TextArea.NUMERIC) {
        setInputModeOrder(new String []{NUMBERS_SYMBOLS_MODE});
        return;
    }
    setInputModeOrder(defaultInputModeOrder);
}