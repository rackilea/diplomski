@Stateless
@Interceptors(InterceptorA.class)
public class StatelessA{
public void methodA(Object reserved, ...other params )

@Stateless
@Asynchronous
@Interceptors(InterceptorB.class)
public class StatelessB{
public void methodB(Object reserved, ...other params)