String var1 = "1", var2 = "2"
if (map.get(var1).get(var2))
{
   /* Without proper initialization map.get(var1) could be null,
    * so it's important that you create the innermap up on first use of 'var1':
    * map.put(var1, new HashMap<String, Boolean>());
    *
    * and to associate var1 and var2 with a boolean value:
    * map.get(var1).put(var2, true);
    */
}