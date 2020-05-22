public <T extends zwave> T Find(List<T> Zwave,List<List<String>> listofinputstrings)
{

for(List<String> lst: listofinputstrings)
{
    for(String str: lst)
    {
        for (T rm: Zwave)
        {
    if(rm instanceof Scene){
        Method method=null;
        try {
             method = rm.getClass().getMethod("getKeyword");
                           if ( method.invoke(rm).equals( str.toLowerCase()))
                           {
                                  return  rm;
                            }
            } catch (Exception e) {
             e.printStackTrace();
            } 

    }


        }

    }
}


return  null;