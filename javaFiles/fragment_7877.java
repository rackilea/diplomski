int id =0;

HashMap<Integer, String> xmlQueryNode = new HashMap<Integer, String>();
HashMap<Integer, HashMap<Integer, String>> splunkHashMap = new HashMap<Integer, HashMap<Integer, String>>();
id = 0;
xmlQueryNode.put(0, "F0name");
xmlQueryNode.put(1, "L0name");
xmlQueryNode.put(2, "M0name");

splunkHashMap.put(id, xmlQueryNode);

xmlQueryNode = new HashMap<Integer, String>();
id = 1;
xmlQueryNode.put(0, "F1name");
xmlQueryNode.put(1, "L1name");
xmlQueryNode.put(2, "M1name");

splunkHashMap.put(id, xmlQueryNode);

xmlQueryNode = new HashMap<Integer, String>();
id = 2;
xmlQueryNode.put(0, "F2name");
xmlQueryNode.put(1, "L2name");
xmlQueryNode.put(2, "M2name");

splunkHashMap.put(id, xmlQueryNode);

xmlQueryNode = new HashMap<Integer, String>();
id = 3;
xmlQueryNode.put(0, "F3name");
xmlQueryNode.put(1, "L3name");
xmlQueryNode.put(2, "M3name");

splunkHashMap.put(id, xmlQueryNode);

for (Integer key : splunkHashMap.keySet()) {
    HashMap<Integer, String> temp =  new HashMap<Integer, String>();
    //System.out.println(key);
    temp = splunkHashMap.get(key);
    for(Integer key1: temp.keySet()){
        System.out.println(temp.get(key1));
    }
}