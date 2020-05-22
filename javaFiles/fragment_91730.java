Set<Parent> parents = store.getParents();
parents.add(new Parent()); 
parents.add(new Child()); 
store.getParents().add(new Child()); //Note the lack of generics

for(Parent curEntry : store.getParents()) {

}