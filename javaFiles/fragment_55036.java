public Seq<Column> getSeqString(Column a, Column b)
    {
        ArrayList<Column> cols = new ArrayList<Column>();
        cols.add(a);
        cols.add(b);
        return scala.collection.JavaConverters.collectionAsScalaIterableConverter(cols).asScala().toBuffer();
    }