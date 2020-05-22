public void remove(ItemsList iList) {
    if (iList.isEmpty()) {
        System.out.println("The list is empty.");
    } else {
        ItemNode prev = null;
        ItemNode a = this.first;
        while (a != null) {
            for (ItemNode b = iList.first; b != null; b = b.next) {
                if (a.item == b.item) prev.next = a.next;
            }
            a = a.next;
        }
    }
}