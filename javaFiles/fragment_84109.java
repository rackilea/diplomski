public static void performRecursiveUiAction(Component comp, Event event) {
  if (comp.getParent() == null) {
     return;
  }
  if (comp.getParent() instanceof MyInteface) {
     ((MyInterface)comp.getParent()).performSpecialAction(event);
  }
  ThisUtility.performRecursiveUiAction(comp.getParent(), event);