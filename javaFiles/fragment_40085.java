// Fetch the parent
Parent parent = entityManager.find( Parent.class, parentId );

// Add a new child entity to parent
entityManager.getTransaction().begin();
Child child = new Child( "Naros" );
child.setParent( parent );
parent.getChildren().add( child );
entityManager.persist( child );
entityManager.merge( parent );    
entityManager.getTransaction().commit();

// Update a child entity 
entityManager.getTransaction().begin();
child.setName( "Naros2" );
entityManager.merge( child );
entityManager.getTransaction().commit();

// Remove child entities from parent
entityManager.getTransaction().begin();
parent.getChildren().forEach( c -> c.setParent( null ) );
parent.getChildren().clear();
entityManager.merge( parent );
entityManager.getTransaction().commit();