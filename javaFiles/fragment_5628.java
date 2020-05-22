char[] values = {'x', 'y', 'z', 't'};
for (char c : values) {
    Bar bar = peekAndGet(c);
    if (bar != null) return produce(bar);
}
return null;