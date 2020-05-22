for (int i = 0; i < dataModel.getSize(); i++) {
    E element = dataModel.getElementAt(i);
    if (anObject.equals(element)) {
        found = true;
        objectToSelect = element;
        break;
    }
}