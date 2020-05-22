718     private String getRequiredParameterName(MethodParameter methodParam) {
719     String name = methodParam.getParameterName();
720     if (name == null) {
721         throw new IllegalStateException(
722                 "No parameter name specified for argument of type [" + methodParam.getParameterType().getName() +
723                         "], and no parameter name information found in class file either.");
724     }
725     return name;
726 }