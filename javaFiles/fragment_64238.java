public class MyClass extends EmptyInterceptor {

     @Override
     public String onPrepareStatement(String sql) {
         sql = "SET ANSI_WARNINGS OFF;".concat(sql);
         return super.onPrepareStatement(sql);
     }
}