public class NE {
     public Integer startIndex;
     public Integer endIndex;
}

public class CustomComparator implements Comparator<NE> {
    public int compare(NE n1, NE n2) {
        return n1.startIndex.compareTo(n2.startIndex);
    }
}

ArrayList<NE> NEList = getIndexes();
Collections.sort(NEList, ner.new CustomComparator());

String finalString = 'John is a student. He is also a researcher. He is also a human.';
for(int i=NEList.size()-1;i>=0;i--){
    NE ne = ner.new NE();
    ne = NEList.get(i);
    finalString = new StringBuilder(finalString).replace(ne.startIndex, ne.endIndex, 'x').toString();
}
System.out.println(finalString);