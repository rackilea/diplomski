Method m = null;
    if(null !=signature && !signature.isEmpty()) {

        m = obj.getClass().getMethod(method, parameterTypes);
    } else {
        m = obj.getClass().getMethod(method);
        arguments = null;
    }

    Object response = m.invoke(obj, arguments);
    return response;