String[] objectNameArray;   
    objectNameArray = objectName.split(".");

    try {
        Class<?> clazz = Class.forName(objectNameArray[1]);
        Object context = getContext();
        Constructor<?> constructor = clazz.getConstructor( context.getClass() );
        Object instance = constructor.newInstance( context );

    } catch( ClassNotFoundException e ) {
        e.printStackTrace();
    } catch( SecurityException e ) {
        e.printStackTrace();
    } catch( NoSuchMethodException e ) {
        e.printStackTrace();
    } catch( IllegalArgumentException e ) {
        e.printStackTrace();
    } catch( InstantiationException e ) {
        e.printStackTrace();
    } catch( IllegalAccessException e ) {
        e.printStackTrace();
    } catch( InvocationTargetException e ) {
        e.printStackTrace();
    }