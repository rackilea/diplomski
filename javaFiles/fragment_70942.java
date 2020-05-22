MethodSpec.Builder payloadInterpreterMethod = MethodSpec.methodBuilder("payloadInterpreter")
          .addModifiers(Modifier.PRIVATE)
          .addModifiers(Modifier.STATIC);
if (condition) {
  payloadInterpreterMethod.addParameter(Response.class, "getResponse");
} else {
  payloadInterpreterMethod.addParameter(CoapResponse.class, "getResponse");
}