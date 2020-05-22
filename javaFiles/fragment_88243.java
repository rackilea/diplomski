public List<String[]> someThing(String q) {
    DAOThings controller = new DAOThings();
    List<Entity> things = controller.getSomeThings(Integer.parseInt(q));
    List<String[]> list = new ArrayList<>;

    for (Entity value : things) {
            String[] array = new String[obj_fields];
            array[0] = value.getAny();
            ...
            array[n] = value.getAny();
            list.add(array);
    }
    return list;
}