import java.lang.reflect.Method; 

try 
    {
        Object f1 = new Foo();
        Object f2 = new Bar();

        Class c1 = f1.getClass();
        Class[] param = new Class[1];   
        param[0] = String.class;
        Method method;
        method = c1.getDeclaredMethod("meth", param);
        method.invoke(f1, "$$$$$$$$$$$$$$");

    } catch (NoSuchMethodException | SecurityException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IllegalArgumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }