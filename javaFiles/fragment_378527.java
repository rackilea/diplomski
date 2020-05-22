public class FilterByClass implements ObjectFilter {
    private Class<?> theClass;
    public FilterByClass( Class<?> clazz ){
        theClass = clazz;
    }
    public boolean accept(Object object){
        return theClass.isInstance( object );
    } 
}