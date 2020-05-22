private Set<T> set = new HashSet<T>();
private List<T> list = new ArrayList<T>();

// Fine
void add(T element)
{
    set.add(element);
    list.add(element);
}

// Fine
void remove(T element)
{
    set.remove(element);
    list.remove(element); // May be expensive, but ... well
}

// Added later, 100 lines below the other methods:
void removeAll(Collection<T> elements)
{
    set.removeAll(elements);
    // Ooops - something's missing here...
}