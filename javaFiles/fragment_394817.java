Vector target = new Vector(1, 2);

List<Vector> vecs = new ArrayList<Vector>();
vecs.add(new Vector(-2, 6));
vecs.add(new Vector(1, 3));
vecs.add(new Vector(4, 0));
vecs.add(new Vector(8, -1));

Vector closest = findClosest(target, vecs);