while (aIter.hasNext() && bIter.hasNext()) {
    E aElem = aIter.next();
    E bElem = bIter.next();
    if (aElem.compareTo(bElem) <= 0) {
        result.add(aElem);
        bIter.pushback(bElem);
    } else {
        result.add(bElem);
        aIter.pushback(aElem);
    }
}