public final Buffer flip() {
    limit = position;
    position = 0;
    mark = -1;
    return this;
}