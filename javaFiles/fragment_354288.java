Set<ConstraintViolation<Foo>> constraintViolations = ...;

Path path = constraintViolations.iterator().next().getPropertyPath();
Iterator<Path.Node> nodeIterator = path.iterator();

Path.Node node = nodeIterator.next();
Bar bar = (Bar) node.as( PropertyNode.class ).getValue();