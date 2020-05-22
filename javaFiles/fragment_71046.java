if (index == target) {
    if (prev == null) {
        head = item.getNode();
        return; // We've removed the target.
    } else {
        prev.setNode(item.getNode());
        return; // We've removed the target.
    }
}