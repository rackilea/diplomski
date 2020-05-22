List<Selection<?>> s = new LinkedList<Selection<?>>();

for (String item : sel) {
    s.add(r.get(item));
}

cq.multiselect(s);