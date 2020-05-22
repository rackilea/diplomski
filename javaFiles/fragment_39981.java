public Module subtractBinding(Module module, Key<?> toSubtract) {
  List<Element> elements = Elements.getElements(module);

  for (Iterator<Element> i = elements.iterator(); i.hasNext(); ) {
    Element element = i.next();
    boolean remove = element.acceptVisitor(new DefaultElementVisitor<Boolean>() { 
      @Override public <T> Boolean visit(Binding<T> binding) { 
        return binding.getKey().equals(toSubtract);
      }
      @Override public Boolean visitOther(Element other) {
        return false;
      }
    }); 
    if (remove) {
      i.remove();
    }
  }

  return Elements.getModule(elements);
}