Author a = new Author("George Orwell");  // transient entity

em.refresh(a); // attach the entity to the persistence context. 
               // persist() or merge() would also attach it

em.detach(a);  // detach it from the context

em.delete(a);  // delete a detached entity.
               // The EM throws llegalArgumentException