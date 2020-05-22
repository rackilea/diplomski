@PrePersist
public void prePersist()
{
    if (created == null)
    {
        created = updated = createCurrentTimestamp();
        createdBy = updatedBy = CurrentUser.get();
    }
}

@PreUpdate
public void preUpdate()
{
    updated = createCurrentTimestamp();
    updatedBy = CurrentUser.get();
}

public static java.sql.Timestamp createCurrentTimestamp ()
{
    final long now = System.currentTimeMillis();
    final java.sql.Timestamp ts = new java.sql.Timestamp (now);
    ts.setNanos(((int)(now % 1000)) * 1000000);
    return ts;
}