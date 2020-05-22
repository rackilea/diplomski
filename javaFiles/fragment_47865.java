Object[] elements;

public Stack() 
{
    elements = new Object[DEFAULT_INITIAL_CAPACITY];
}

public push(E e)
{
    ...
    elements[size++] = e;
}

public E pop()
{
    ...
    E result = (E)element[size--];
}