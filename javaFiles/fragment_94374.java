public class WordCountComparator implements Comparator<Tuple2<String, Integer>>, Serializable {

@Override
public int compare(Tuple2<String, Integer> o1, Tuple2<String, Integer> o2) {
    // TODO Auto-generated method stub
    return o2._2()-o1._2();
}



}