for (Class<? extends Handler> handlerType : getHandlerClasses()) {
    Type[] implementedInterfaces = handlerType.getGenericInterfaces();
    ParameterizedType eventHandlerInterface = (ParameterizedType) implementedInterfaces[0];
    Type[] types = eventHandlerInterface.getActualTypeArguments();
    Class dataType = (Class) types[0]; // <--String or Date, in your case
    factory.registerHandler(dataType, handlerType);
}