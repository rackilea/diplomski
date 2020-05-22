public List<String> combine(final List<Set<String>> toJoin) {
    final List<String> outputs = new ArrayList<>(toJoin.size());
    for (final Set<String> items : toJoin) {
        outputs.add(join(items));
    }
    return outputs;
}

private String join(final Set<String> items) {
    final Iterator<String> iter = items.iterator();
    final StringBuilder sb = new StringBuilder();
    sb.append(iter.next());
    while (iter.hasNext()) {
        sb.append(", ").append(iter.next());
    }
    return sb.toString();
}