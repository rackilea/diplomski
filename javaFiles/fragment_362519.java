clone():
    copy = new Stack;
    helper = new Stack;
    while not this.is_empty():
        helper.put(this.pop());
    while not helper.is_empty():
        item = helper.pop();
        copy.put(item);
        this.put(item);
    return copy;