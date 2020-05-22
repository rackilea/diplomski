public final boolean validateFields(final HashMap<JTextField, int[]> textFieldMap) {
    boolean flag = false;
    for (Map.Entry<JTextField, int[]> entry : textFieldMap.entrySet()) {
        JTextField field = entry.getKey();
        for (int constant : entry.getValue()) {
            Constants enumConstant = ...; //mapping from int if you need to keep ints
            flag = enumConstant.validate();
        }
    }
    return flag;
}