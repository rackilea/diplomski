private void selectIndexInList(int index) {
    this.selectionComesFromTheCode = true;
    try {
        list.setSelectedIndex(index);
    }
    finally {
        this.selectionComesFromTheCode = false;
    }
}

@Override
public void valueChanged(ListSelectionEvent e) {
    if (!this.selectionComesFromTheCode) {
        ...
    }
}