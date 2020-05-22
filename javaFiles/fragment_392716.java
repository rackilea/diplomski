package com.stackoverflow.q1747780;

import java.util.List;

public interface Service<T>
{
    public List< UUIDTyped<T> > search(String text);

    public T fetch( UUIDTyped<T> uuid);
}