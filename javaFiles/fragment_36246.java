class ExtendedData<T> implements ExtendedOperatorDispatcher {
    T _data;
    Object _extension;
    private Class<? extends Object> _dataClass;
    private Class<? extends Object> _extensionClass;

    public ExtendedData(T data, Object extension) {
        _data = data;
        _extension = extension;
        _dataClass = (_data == null ? Object.class : _data.getClass());
        _extensionClass = (_extension == null ? Object.class : _extension
                .getClass());
    }

    @Override
    public void dispatchDoSomething(OperatorDispatch operator) {
        try {
            Method foundMethod = null;
            for (Method method : operator.getClass().getMethods()) {
                Class<?>[] params = method.getParameterTypes();
                if ("doSomething".equals(method.getName())
                        && params.length == 1)
                    if (params[0].isAssignableFrom(_dataClass)) {
                        if (foundMethod == null)
                            foundMethod = method;
                        else
                            throw new IllegalArgumentException(
                                    "Multiple method can be called");
                    }
            }
            foundMethod.invoke(operator, _data);
        } catch (SecurityException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dispatchDoSomething(ExtendedOperatorDispatch operator) {
        try {
            Method foundMethod = null;
            for (Method method : operator.getClass().getMethods()) {
                Class<?>[] params = method.getParameterTypes();
                if ("doSomething".equals(method.getName())
                        && params.length == 2)
                    if (params[0].isAssignableFrom(_dataClass) && params[1].isAssignableFrom(_extensionClass)) {
                        if (foundMethod == null)
                            foundMethod = method;
                        else
                            throw new IllegalArgumentException(
                                    "Multiple method can be called");
                    }
            }
            foundMethod.invoke(operator, _data, _extension);
        } catch (SecurityException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}