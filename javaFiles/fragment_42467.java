public class MyClassLoader extends ClassLoader{
    public Class<?> instrument(Class<?> in){
        try{
            Transformer.transformMe.add(in);
            Transformer.instrumentation.retransformClasses(in);
            Transformer.transformMe.remove(in);
            return in;
        }catch(Exception e){ return null; }
    }
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return instrument(super.loadClass(name));
    }
}