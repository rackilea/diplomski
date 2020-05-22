public class CustomEntityRepo{



    public Entity findById(Long id){

        Entity entity = session.get(Entity.class, id);

        if(entity.getControl.equals(\* custom condition*\)){
            entity.getBulla.().size(); // init the collection
        }

        return entity;
    }

}