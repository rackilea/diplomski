public class MyClass {

private List<Term> mTermList = null;

private void init() {
    mTermList = new ArrayList<Term>();
}


private void addSomeTerm() {
     Map<String, Integer> propertyMap = new LinkedHashMap<String, Integer>();

     propertyMap.put("p1", 1);
     propertyMap.put("p2", 2);
     propertyMap.put("p3", 3);

     List<String> entitiesList = new ArrayList<String>();
     entitiesList.add("T1");
     entitiesList.add("T2");


     Term term = new Term("a1");
     term.generate(propertyMap, entitiesList);

     mTermList.add(term);
}

private String printTerms() {

    StringBuilder buff = new StringBuilder();

    for(Term currTerm : mTermList){

        buff.append(currTerm.getName()).append("     ");

        Map<String, Integer> propertyMap = currTerm.getPropertyMap();


        Set<String> sets = propertyMap.keySet();

        Iterator<String> itr = sets.iterator();

        String key = null;
        Integer value = null;

        while(itr.hasNext()){

            key = itr.next();               
            value = propertyMap.get(key);

            buff.append(key + "=" + value).append(",");
        }

        buff.setLength(buff.length()-1); // remove last ','

        buff.append("     ");

        List<String> entitiesList = currTerm.getEntitiesList();

        for(String str : entitiesList){
            buff.append(str).append(",");
        }

        buff.setLength(buff.length()-1); // remove last ','         

    }

    return buff.toString();
}


/**
 * @param args
 */
public static void main(String[] args) {

    MyClass m = new MyClass();
    m.init();

    m.addSomeTerm();

    System.out.println(m.printTerms());
}