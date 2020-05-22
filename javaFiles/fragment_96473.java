Object action = ???; // perhaps you need .newInstance() for action class
                     // Hopefully you have a interface with performLogic

String methodName = "performLogic";
try {
    Method method = action.getClass().getMethod(methodName, param1.class, param2.class);
    method.invoke(action, param1, param2);
} catch (SecurityException | NoSuchMethodException e) {
    // Error by get Method
} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {        
    // Error by call Method
}