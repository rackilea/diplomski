// assuming the processingEnvironment got passed to the method.
// It is a good idea to store the elementUtil somewhere
// globally accessible during annotation processing.
Elements elementUtils = processingEnvironment.getElementUtils();
...
TypeMirror stringType =
    elementUtils.getTypeElement(String.class.getCanonicalName()).asType();
...
ExecutableElement exeElement = (ExecutableElement) e;
List<? extends VariableElement> params = exeElement.getParameters();
TypeMirror secondArgumentType = params.get(1).asType();

// I find the explicit version has a less cognitive complexity. Feel free to change it.
if (secondArgumentType.equals(stringType) == false) { 
    // TODO: halt and catch fire!
}

// from here on, you can be certain that the second argument is a String.
...