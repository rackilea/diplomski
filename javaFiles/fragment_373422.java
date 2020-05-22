if ((e.getModifiers() & MouseEvent.BUTTON1_MASK) != 0) {
    System.out.println("BUTTON1_MASK");
}

if ((e.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
    System.out.println("BUTTON1_DOWN_MASK");
}