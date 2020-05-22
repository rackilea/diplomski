class TransientInterceptor extends EntityInterceptor {
      ThreadLocal<Boolean> transientFlag = new ThreadLocal<Boolean)();
      public boolean isTransient() {
         return transientFlag.get()==Boolean.TRUE;
      }
      static public setTransient(boolean b) {
          transientFlag.set(b);
      }
   }