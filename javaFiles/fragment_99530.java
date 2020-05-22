Service s = new Service();
ArrayList<Service> elements = s.getElements();

Container<Container> c = new Container<Container>();
ArrayList<Container> els = c.getElements();

//adding an element to each of the lists:
c.getElements().add(new Container<Container>());
System.out.println(c.getElements().size());

s.getElements().add(new Service());
System.out.println(s.getElements().size());