Parent parent = parentRepository.findById(1);
Child child = new Child();
parent.getChildList().add(child);
parent = parentRepository.save(parent); <---------- use returned value with ids set

System.out.println("child's id: " + parent.getChildList().get(0).getId()); <-- access saved child through parent list