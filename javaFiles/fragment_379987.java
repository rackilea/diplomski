private Map<Object, Integer> buttonMap = new HashMap<Object, Integer>

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
    Integer counter = null;
    int[] selection = jList3.getSelectedIndices();

    for (int i = 0; i < selection.length; i++){ 
        Object selString = jList3.getModel().getElementAt(selection[i]);
        counter = buttonMap.get(selString);
        if(counter == null) {
            buttonMap.put(selString, new Integer(0));
        }

        buttonMap.put(selString, new Integer(counter.intValue() + 1));
        System.out.println(selString + " has been clicked " + buttonMap.get(selString) + " times.");
    }
}