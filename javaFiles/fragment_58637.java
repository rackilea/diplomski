public class LinkLikeInvokeVirtual {
    public static CallSite bootstrap(MethodHandles.Lookup l, String name, MethodType type){
        Class<?> receiver = type.parameterType(0);
        type = type.dropParameterTypes(0, 1);
        System.out.println("linking to "+name+type+" in "+receiver);
        MethodHandle target;
        try {
            target = l.findVirtual(receiver, name, type);
        } catch(NoSuchMethodException|IllegalAccessException ex) {
            throw new BootstrapMethodError(ex);
        }
        return new ConstantCallSite(target);
    }
}