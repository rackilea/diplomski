mapPartitions(new FlatMapFunction<Iterator<Row>, Row>(){

        @Override
        public Iterator<Row> call(Iterator<Row> t) throws Exception {
            List<Row> list = new ArrayList<Row>();
            Integer last = 0;
            while(t.hasNext()) {
                Row current = t.next();
                list.add(RowFactory.create(current.get(0), current.get(1), last > 0 ? (current.getInt(1) - last) : 1)); // in this line new column (difference) has been insert to dataset
                last = current.getInt(1);
            }
            return list.iterator();
        }

    })