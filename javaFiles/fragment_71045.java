public void deleteItem(int target) 
{
    int index = 0;
    CarNode item = head;
    CarNode prev = null;

    while(item != null)
    {
        if (index == target) {
            if (prev == null) {
                head = item.getNode();
                return; // We've removed the target.
            } else {
                prev.setNode(item.getNode());
                return; // We've removed the target.
            }
        }
        prev = item;
        item = item.getNode();
        index++;
    }
}