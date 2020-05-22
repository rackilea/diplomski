List<Character> result = new LinkedList<Character>();
    Iterator<Character> iter = list.iterator();
    if (!iter.hasNext()) { /*handle empty list and return*/ }
    Character last = iter.next();
    if (last.charValue() == 'i') {
        result.add(last);
    }
    while (iter.hasNext()) {
        Character current = iter.next();
        if (last.charValue() == current.charValue()) { 
            last = current; //we don't care for i's which i is the last, but we do for o's, so we set it anyway.
            continue;
        } else if (current.charValue() == 'i') {
            result.add(last);
            result.add(current);
        }
        last = current;
    }
    if (last.charValue() == 'o') {
        result.add(last);
    }