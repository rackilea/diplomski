SomeObject objectReference = ...; // The object you're interested in
Class clazz = SomeObject.class;
int nullCount = 0;
for (Field field : clazz.getDeclaredFields())
{
    field.setAccessible(true);
    if (field.get(objectReference) == null)
    {
        nullCount++;
    }
}