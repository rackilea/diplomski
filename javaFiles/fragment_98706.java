Iterator<CheckbleItem> it = items.iterator();
while (it.hasNext()) {
    CheckableItem next = it.next();
    if (next.isSelected()) {
        mainPanel.remove(next.getComponent());
        it.remove();
        continue;
    }
}