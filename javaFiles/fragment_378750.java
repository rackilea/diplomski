public int howManyMailItems(String who)
{
    int count = 0;
    for(ArrayList<MailItem> array : mailMap.values()) {
        for (MailItem item : array) {
            if (item.getTo().equals(who)) {
                count++;
            }
        }
    }
    return count;
}