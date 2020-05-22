public final boolean validateFields(final HashMap<JTextField, Constants[]> textFieldMap) {
    boolean flag = false;
    for (Map.Entry<JTextField, Constants[]> entry : textFieldMap.entrySet()) {
        JTextField field = entry.getKey();
        for (Constants constant : entry.getValue()) {
            flag = constant.validate();
        }
    }
    return flag;
}