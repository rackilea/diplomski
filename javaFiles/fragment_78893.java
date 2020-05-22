public class TableInterceptor extends EmptyInterceptor {

   @Override
   public boolean onFlushDirty(Object entity, Serializable id,
                               Object[] currentState, Object[] previousState,
                               String[] propertyNames, Type[] types){

         // do comparison logic on fields and save to DB
   }
}