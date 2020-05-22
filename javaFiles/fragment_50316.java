static List<Input> getInputs(Object thisObj, String ... fields) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException
{
   final List<Input> retVal = new ArrayList<Input>();
   for (String field : fields)
   {
      Field f = thisObj.getClass().getDeclaredField(field);
      f.setAccessible(true);
      retVal.add(new Input(f.getType().getSimpleName(), field, (String )f.get(thisObj)));
   }
   return retVal;   
}