for (int i = 0; i < sortedEntries.size(); i++)
{
    Entry<Subnet, Set<String>> subnet = sortedEntries.get(i);

    for (int j = i + 1; j < sortedEntries.size(); j++)
    {
        Entry<Subnet, Set<String>> nextNet = sortedEntries.get(j);
        if (!subnet.getKey().isPrefix(nextNet.getKey()))
        {
            break;
        }

        Entry<Subnet, Set<String>> nextNextNet = j < sortedEntries.size() - 1 ? sortedEntries.get(j + 1) : null;
        if (nextNextNet == null || !subnet.getKey().isPrefix(nextNextNet.getKey()))
        {
            // biggest, and last superset found
            nextNet.getValue().addAll(subnet.getValue());
            sortedEntries.remove(i);
            i--;
        }
        else if (!nextNet.getKey().isPrefix(nextNextNet.getKey()))
        {
            // biggest superset found, but not last
            nextNet.getValue().addAll(subnet.getValue());
        }
    }
}