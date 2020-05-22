public E poll() {
    if (size==0)
        return null;
    return removeFirst(); // if the first element is null, `removeFirst()`
                          // returns null, and you might mistakenly assume
                          // the Queue is empty
}