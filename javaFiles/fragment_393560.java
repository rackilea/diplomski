public int getFrequencyOf(T anEntry)
{
    Node current = head;
    int result = 0;

    for (int i = 0; i < numberOfEntries; i++) {
        if (current.data.equals(anEntry)) {
            result++;
        }
        current = current.next;
    }

    return result;
}