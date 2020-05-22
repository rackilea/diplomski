/**
 * Adapt the current instance to the type
 * denoted by clazz else return null
 * ...
 */
public <T> T adapt(Class<T> clazz){
    if( clazz.isInstance(this)){
        return (T)this;
    }
    return null;
}