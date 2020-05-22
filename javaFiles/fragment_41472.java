import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.ares.cdi.hibernate.sf.MySessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

@Interceptor
@Transactional
public class TransactionManager {

    @Inject
    private MySessionFactory sessionFactory;

    @AroundInvoke
    public Object handleTransaction(InvocationContext context) throws Exception{
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            return context.proceed();
        }
        catch(Exception e){
            tx.rollback();
            throw e;
        }
        finally{
            if(tx.getStatus().equals(TransactionStatus.ACTIVE)){
                try{
                    tx.commit();
                }
                catch(Exception e){
                    tx.rollback();
                    throw e;
                }
            }
        }
    }
}



import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Transactional {



}