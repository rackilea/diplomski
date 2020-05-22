JavaRDD<Table2> table2 = session_7.map(new Function<Tuple2<KeyTable2, ValueTable2>, Table2>() {
       @Override
       public Table2 call(Tuple2<KeyTable2, ValueTable2> keyTable2ValueTable2Tuple2) throws Exception {
           SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
           Date startdate = formatter.parse(keyTable2ValueTable2Tuple2._1.time.replace("+","."));
           Date endtdate = formatter.parse(keyTable2ValueTable2Tuple2._1.endtime.replace("+","."));
           Table2 t = new Table2(keyTable2ValueTable2Tuple2._2.canal,keyTable2ValueTable2Tuple2._2.motif,startdate,endtdate,keyTable2ValueTable2Tuple2._1.client);
           return t;
       }
   });

    javaFunctions(table2).writerBuilder("Schema", "Table", mapToRow(Table2.class)).saveToCassandra();