public class Migrator {

   private final IEntity entity;
   private Class<? extends IEntity> newestClass = Entity_new.class;

   public Migrator(final IEntity entity){
    this.entity = entity;
   }

   public Migrator setNewestClass(Class<? extends IEntity> clazz){
     this.newestClass = clazz;
     return this;
   }

   public IEntity migrate() throws Exception {
     Constructor<? extends IEntity> constr =  
        newestClass.getConstructor(IEntity.class);
     return constr.newInstance(this.entity);
   }
}