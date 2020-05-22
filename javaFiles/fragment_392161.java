int count = 0;

for(final Iterator iterator = list.iterator(); iterator.hasNext();) {
    final Object o = iterator.next();

    if (++count == 5) {
        iterator.remove();
    }

    o.toString();
}