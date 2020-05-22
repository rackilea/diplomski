private static class ListData extends AbstractListModel<Person> {
    private final ArrayList<Person> lista = new ArrayList<>();

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Person getElementAt(int index) {
        return lista.get(index);
    }

    public void addPerson(int height, int weight, String name, String size) {
        int index = lista.size();
        lista.add(index, new Person(height, weight, name, size));
        fireIntervalAdded(this, index, index);
    }
}