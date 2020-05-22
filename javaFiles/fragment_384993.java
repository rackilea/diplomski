Query query = session.createQuery("from A");
List<Object> objects = query.list();
for (Object object: objects) {
    System.out.print("A property: ");
    System.out.print(((A)object).getAProperty());
    System.out.print(", B property: ");
    System.out.println( (object.getClass() == B.class) ? ((B)object).getBProperty() : "not a B");
}