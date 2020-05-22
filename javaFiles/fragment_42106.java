final CheckboxTreeViewer treeViewer = new CheckboxTreeViewer(parent);

// When user checks a checkbox in the tree, check all its children
treeViewer.addCheckStateListener(new ICheckStateListener() {
public void checkStateChanged(CheckStateChangedEvent event) {
    // If the item is checked . . .
    if (event.getChecked()) {
      // . . . check all its children
      treeViewer.setSubtreeChecked(event.getElement(), true);
    }
  }
});

// Get the selected elements from the tree
Object[] actuallyChecked = treeViewer.getCheckedElements();