Cat myCat = new Cat();
int whiskers;

try
{
    Field field = Cat.class.getDeclaredField("numberOfWhiskers");
    // This line bypasses the private control
    field.setAccessible(true);
    whiskers = field.getInt(myCat);
}
catch (NoSuchFieldException e) { /* Handle */ }
catch (IllegalAccessException e) { /* Handle */ }