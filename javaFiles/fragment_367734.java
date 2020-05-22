public class UseIdOrGenerate extends IdentityGenerator {    
    @Override
    public Serializable generate(SessionImplementor session, Object obj) throws HibernateException {
        if (obj == null) throw new HibernateException(new NullPointerException()) ;

        if ((((EntityWithId) obj).getId()) == null) {//id is null it means generate ID
            Serializable id = super.generate(session, obj) ;
            return id;
        } else {
            return ((EntityWithId) obj).getId();//id is not null so using assigned id.

        }
    }
}