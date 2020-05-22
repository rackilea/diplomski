JCheckBox cb = new JCheckBox();
try {
    Method method = cb.getClass().getDeclaredMethod("setSelected", boolean.class);
    System.out.println("1. " + method);
} catch (NoSuchMethodException | SecurityException ex) {
    ex.printStackTrace();
}
try {
    Method method = cb.getClass().getMethod("setSelected", boolean.class);
    System.out.println("2. " + method);
} catch (NoSuchMethodException | SecurityException ex) {
    ex.printStackTrace();
}
try {
    Method method = findMethod(cb.getClass(), "setSelected", boolean.class);
    System.out.println("3. " + method);
} catch (NoSuchMethodException ex) {
    ex.printStackTrace();
}