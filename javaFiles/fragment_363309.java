final Bucket statsBucket = db.getStatsBucket();
int limitCount = 10000;
int skipCount = 0;

System.out.println("reading stats ids ...");

try (DataOutputStream out = new DataOutputStream(new FileOutputStream("rowIds.tmp")))
{
    String lastKeyDocId = null;

    while (true)
    {
        ViewResult result;

        if (lastKeyDocId == null)
        {
            result = statsBucket.query(ViewQuery.from("Stats", "AllLogs").limit(limitCount).stale(Stale.FALSE));
        }
        else
        {
            result = statsBucket.query(ViewQuery.from("Stats", "AllLogs").limit(limitCount).stale(Stale.TRUE).startKey(lastKeyDocId).skip(1));
        }

        Iterator<ViewRow> rows = result.iterator();

        if (!rows.hasNext())
        {
            break;
        }

        while (rows.hasNext())
        {
            lastKeyDocId = rows.next().id();
            out.writeUTF(lastKeyDocId);
        }

        skipCount += limitCount;
        System.out.println(skipCount);
    }
}