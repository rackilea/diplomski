class DefaultKeySelectionManager implements KeySelectionManager, Serializable {
    public int selectionForKey(char aKey,ComboBoxModel aModel) {
....
       for ( i = ++currentSelection, c = aModel.getSize() ; i < c ; i++ ) {
            Object elem = aModel.getElementAt(i);
            if (elem != null && elem.toString() != null) {
                v = elem.toString().toLowerCase();
                if ( v.length() > 0 && v.charAt(0) == aKey )
                    return i;
            }
        }