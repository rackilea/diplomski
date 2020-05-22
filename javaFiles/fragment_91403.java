Method[] methods = NewMain.class.getMethods();
for (Method m: methods)
{
   if (m.getName().equals("func"))
      m.invoke(null, arr);
}