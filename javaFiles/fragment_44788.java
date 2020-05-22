static <R, T> R runFunction(Function<R, T> function, T ... input){
    try{
       return function.call(input);
    } catch(NullPointerException _null){
       m_Logger.error("Null error exception caught in Blah::Foo");
       return null;
    } catch(Exception ex){
       m_Logger.error( ex.getMessage() );
       return null;
    }
}