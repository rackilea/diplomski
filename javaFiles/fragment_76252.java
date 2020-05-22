public int indexOf(Object o) {
    ...
        // Here Object "o" is of Type Integer in your case, So It calls Integer.equals
        if (o.equals(elementData[i]))
    ...
    // If not equal or not found.
    return -1;
    }