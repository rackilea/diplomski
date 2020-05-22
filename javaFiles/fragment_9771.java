void baseMethod(Consumer<Parameter> partialMethod, Parameter param) {
  //common stuff
  param.setItem(item);
  //set other relevant things
  partialMethod.accept(param);
}

//example use:
baseMethod(this::partialMethod1, new Parameter(replay=true, ...));

void partialMethod1(Parameter param) {
  //do what you gotta do
  param.getItem().setReplay(param.getReplay));
  param.getItem().rewind();
}