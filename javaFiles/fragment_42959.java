MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
Method method = signature.getMethod();
String methodName = method.getName();
if (method.getDeclaringClass().isInterface()) {
  method = proceedingJoinPoint.getTarget().getClass().getDeclaredMethod(methodName,
      method.getParameterTypes());
}