class EntityManagerFactoryHolder {
private static EnityManager entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");

public EntityManagerFactory getEntityManager(){
    return entityManagerFactory;
} 
}