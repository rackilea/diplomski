public static void main(String[] args) 
{
    Worker worker = new Worker();
    Class clazz = worker.getClass();
    Method[] methods = clazz.getDeclaredMethods();

    for(Method method :methods)
    {
        System.out.println(method.getName()+ " is in Worker: "+ !method.isBridge());
    }
}