@POST
@Override
@Consumes({"application/xml", "application/json"})
public void create(ObjectC entity) {

    if(entity.getObjectA().getId()==null){//If objectA doesn't have an ID, it must be new

            entity.getObjectB().setObjectA(entity.getObjectA());
            em.persist(entity.getObjectA());
            em.persist(entity.getObjectB());
            em.persist(entity);     


    }else{//Otherwise, everything may be inserted at once.
        super.create(entity);        
    }

}