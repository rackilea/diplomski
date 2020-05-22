Map<Integer, Integer> map = new HashMap<Integer, Integer>();

//java
for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
{
    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
}

//mvel
foreach (c : map.entrySet) 
{

   System.out.println("Key = " +c.key + ", Value = " +c.value);
}