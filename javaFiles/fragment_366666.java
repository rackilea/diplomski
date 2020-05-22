public List<List<T>> transpose(Collection<Collection<T>> table) {
    boolean init = false;

    List<List<T>> result = new ArrayList<List<T>>();
    for (Collection<T> row: table) {
        if (!init) {
            for(int i = 0; i < row.size(); i++)
                result.add(new ArrayList<T>(table.size());
            init = true;
        }

        for(int i = 0; i < row.size(); i++)
            result.get(i).add(row.get(i));
    }

    return result;
}