ValueListBox<Integer> semester = new ValueListBox<Integer>(new Renderer<Integer>() {
    public String render(Integer object) {
        String s = "";
        if (object != null) {
            s = object.toString();
        }
        return s;
    }

    public void render(Integer object, Appendable appendable) throws IOException {
        String s = render(object);
        appendable.append(s);
    }
}) {
    @Override
    public void setAcceptableValues(Collection<Integer> newValues) {
        super.setAcceptableValues(new HashSet<Integer>(newValues));
    }
};

semester.setAcceptableValues(Arrays.asList(1, 1, 3, 3, 2, 2, 3, 4, 5, 7, 8, 9, 1, 3, 2));
semester.setValue(2);