Graph g = new Graph();
g.addVertex("Doctor",new DrVertex("Dr. Smith"));
g.addVertex("Doctor",new DrVertex("Dr. Cooper"));
List<Vertex> doctors = g.get("Doctor");
assertTrue("Dr. Smith",doctors.get(0));
assertTrue("Dr. Cooper",doctors.get(1));