for (Iterator<Punk> iter = list.listIterator(); iter.hasNext(); ) {
    Punk p = iter.next();

    if (some condition ) {
        iter.remove();
    }
}