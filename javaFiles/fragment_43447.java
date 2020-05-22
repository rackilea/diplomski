public static Node backup (Node tail)
{
    Node tobebackuped = tail;
    Node backuphead = null;
    Node backup = new Node ();
    Node backuptail = backup;
    while (tobebackuped.prev != null)
    {
        backup.data = tobebackuped.data;
        backuphead = backup;
        backup = new Node ();
        backup.next = backuphead;
        backuphead.prev = backup;
        tobebackuped = tobebackuped.prev;
    }

    return backuptail;
}