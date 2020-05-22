List<Tuple> list = selectFrom(dummy_table).list();
   for (int b=0;b<stockLevels1.length;b++){
    for (int c=0;c<stockLevels1[0].length;c++){
        stockLevels1[b][c]=(int) list.get(c).toArray()[b+1];
        }
        }