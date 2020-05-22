List<Object[]> rows = query.list();
Parent parent = null;
List<Child> children = new ArrayList<Child>(rows.size());
for (Object[] row : rows) {
    parent = (Parent) row[0];
    children.add((Child) row[1]);
}
ParentChildWrapper result = new ParentChildWrapper(parent, children);