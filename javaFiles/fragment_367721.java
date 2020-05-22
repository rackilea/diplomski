CalendarControl control; // The instance to manipulate
try {
    Field field = control.getClass().getDeclaredField("calendar");
    field.setAccessible(true);
    field.set(control, calendar); // Pass the new object we created at top of this answer
} catch (Exception ex) {
    // You must catch NoSuchFieldException and IllegalAccessException here
}