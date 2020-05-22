if (source instanceof JList) {
    JList < String > jList = (JList) e.getSource();
    if (jList != null) {
        String selectedValue = jList.getSelectedValue();
        if (selectedValue != null) {
            selectedIndex = selectedValue;
        } else {
            System.out.println("Failed to get Selected Value. Cause: NullPointerException");
        }
    } else {
        System.out.println("Failed to get JList. Cause: NullPointerException");
    }
}