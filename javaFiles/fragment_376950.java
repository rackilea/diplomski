@Aspect
@Component
public class SomeAspect {

    @Pointcut("@annotation(Authorised)")
    private void AuthorisedMethod() {
    }

    @Before("AuthorisedMethod() && args(personId)")
    public void checkIfIsCurrentlyAuthenticated(JoinPoint joinPoint, PersonId personId) throws NoSuchMethodException {
        System.out.println("aspect " + personId.getId());
    }

}