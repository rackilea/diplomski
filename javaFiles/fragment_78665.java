public boolean inIndex(String key)
    {
        return index.containsKey(key);
    }
public void index(String val,int res1,int res2)
    {   
            List<Integer> intList = new LinkedList<Integer>();         

            if(inIndex(val)==false)
            {
            index.put(val,intList);                                    
            }
            index.get(val).add(res1);
            index.get(val).add(res2);  
        }

    }