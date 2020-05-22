private void combine(List<List<String>> lists, List<String> params, StringBuilder prefix) {
    if (lists.isEmpty()) {
        System.out.println(prefix);
        return;
    }
    for (String value : lists.get(0)) {
        StringBuilder copy = new StringBuilder(prefix);
        if (copy.length() > 0) {
            copy.append(", ");
        }
        copy.append(params.get(0)).append(" = ").append(value);
        combine(lists.subList(1, lists.size()), params.subList(1, params.size()), copy);
    }
}