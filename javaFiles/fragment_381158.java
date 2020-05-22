public class Test
{  

    public static void generate(LinkedList<LinkedList<String>> outerList, String outPut) {
        LinkedList<String> list = outerList.get(0);

        for(String str : list) {
            LinkedList<LinkedList<String>> newOuter = new LinkedList<LinkedList<String>>(outerList);
            newOuter.remove(list);

            if(outerList.size() > 1) {
                generate(newOuter, outPut+str);
             } else {
               System.out.println(outPut+str);
             }
        }
    }

    public static void main(String[] args) 
    {
        LinkedList<LinkedList<String>> outerList = new LinkedList<LinkedList<String>>();

        LinkedList<String> list1 = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();

        list1.add("A");
        list1.add("B");

        list2.add("C");
        list2.add("D");

        outerList.add(list1);
        outerList.add(list2);

        Test.generate(outerList, "");
    }      
}