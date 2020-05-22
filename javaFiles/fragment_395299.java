Connection conn = getConnectionFromSomewhere()
... do a bunch of work ...
if (work was successful)
    conn.commit();
else
    conn.rollback();