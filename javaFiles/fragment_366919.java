private class TupleMapLongComparator implements Comparator<Tuple2<String,Long>>, Serializable {
    @Override
    public int compare(Tuple2<String,Long> tuple1, Tuple2<String,Long> tuple2) {

        if (tuple1._2.compareTo(tuple2._2) == 0) {
            return tuple1._1.compareTo(tuple2._1);
        }
        return -tuple1._2.compareTo(tuple2._2);
    }
}