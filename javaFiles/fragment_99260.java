String android1="TextInputLayout";
    try {
        Class<?> clazz = Class.forName("android.support.design.widget." + android1);
        Constructor<?> constructor = clazz.getConstructor(Context.class);
        Object object = constructor.newInstance(getContext());

        if (object instanceof TextInputLayout) {
            TextInputLayout textInputLayout = (TextInputLayout) object;
        }else {   
        }

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    } catch (java.lang.InstantiationException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    }