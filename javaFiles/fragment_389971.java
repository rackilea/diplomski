@Aspect
public class UpdatableDtoRepositoryAspect {

    private UpdatableDtoManager updatableDtoManager = 
        UpdatableDtoManager.INSTANCE;

    @Pointcut("execution(void demo.DtoRepository.update(*)) " +
            "&& args(object)")
    public void updateMethodInRepository(Object object) {}

    @Around("updateMethodInRepository(object)")
    public void aroundUpdateMethodInRepository(
            ProceedingJoinPoint joinPoint, Object object) {

        Set<String> updatedFields = 
            updatableDtoManager.getUpdatedFieldsForObject(object);

        if (updatedFields.size() > 0) {
            ((DtoRepository<Object>)joinPoint.getTarget()).
                updatePerson(object, updatedFields);
        } else {

            // Returns without calling the repository.
            System.out.println("Nothing to update");
        }
    }   
}