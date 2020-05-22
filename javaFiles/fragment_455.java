@Override
public DateTime from(Timestamp t)     {
    return t == null ? null : new DateTime(t);
}

@Override
public Timestamp to(DateTime u) {
    return u == null ? null : new Timestamp(u.getMillis());
}