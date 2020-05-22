public int howManyMailItems(String who)
{
    int count = 0;
    for(Map.Entry<String,ArrayList<MailItem>> entry : mailMap.entrySet()) {
        String key = entry.getKey();
        ArrayList<MailItem> array = entry.getValue();
        // process key and array value
    }
    return count;
}